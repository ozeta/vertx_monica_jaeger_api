package eta.oz.monica_api.v2.dao;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import eta.oz.monica_api.Utils;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.bson.Document;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class MongoVerticle extends AbstractVerticle {
  MongoClient mongoClient;
  MongoDatabase database;
  MongoCollection<Document> collection;
  private Logger logger = Utils.getLogger(MethodHandles.lookup().lookupClass());
  private Tracer tracer;
  private String getSingleUserOperation = "GET /user/:name";

  private Map<UUID, Span> spanMap;
  private int port = 5050;
  private Router router;
  private EventBus eventBus;

  @Override
  public void start(Future<Void> fut) {
    String user = "";
    String source = "admin";
    char[] password = {};
    eventBus = Utils.getVerx().eventBus();

    MongoCredential credential = MongoCredential.createCredential(user, source, password);

    mongoClient = MongoClients.create(
      MongoClientSettings.builder()
        .applyToClusterSettings(builder ->
          builder.hosts(Arrays.asList(new ServerAddress("host1", 27017))))
        .credential(credential)
        .build());
    database = mongoClient.getDatabase("monica");
    collection = database.getCollection("sessions");
    spanMap = Utils.getSpanMap();
    tracer = Utils.buildTracer("Mongo verticle");

    initializeHandler("monica.mongo.input.countsessions", this::countAllSessions);
    initializeHandler("monica.mongo.input.getAllUsers", this::getAllUsers);
  }

  private void initializeHandler(String address, Consumer<MultiMap> handler) {
    eventBus.<MultiMap>consumer(address, h -> {
      MultiMap params = h.body();
      handler.accept(params);
    });
  }


  public void getAllUsers(MultiMap params) {
    DistinctIterable<Object> users = collection.distinct("user", null);
  }

  private void countAllSessions(MultiMap params) {
    vertx.<Long>executeBlocking(hand -> {
      Long l = collection.countDocuments();
      hand.complete(l);
    }, res -> {
      if (res.succeeded()) {
        Long result = res.result();
        eventBus.send("monica.mongo.out", new JsonObject().put("result", result));
      } else {
        res.cause().printStackTrace();
      }
    });
  }
}
