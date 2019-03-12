package eta.oz.monica_api.v2;

import eta.oz.monica_api.Utils;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("ALL")
public class RestVerticle extends AbstractVerticle {
  private Logger logger = Utils.getLogger(MethodHandles.lookup().lookupClass());
  private Tracer tracer;
  private String getSingleUserOperation = "GET /user/:name";
  private String getUsersOperation = "GET /users";
  private String getSessionOperation = "GET /user/:user/session/:session";
  private Map<UUID, Span> spanMap;
  private int port = 5050;
  private Router router;

  public void usersHandler(RoutingContext routingContext) {
    try (Scope ignored = tracer.buildSpan(getUsersOperation).startActive(true)) {
      UUID uuid = Utils.getUUID();
      ignored.span().log("request started");
      JsonArray data = new JsonArray();
      data.add("mar.carrozzo");
      data.add("espoelena");
      data.add("sav.devito");
      JsonObject response = new JsonObject()
        .put("status", "ok")
        .put("data", data)
        .put("message", "");
      routingContext.response()
        .putHeader("content-type", "application/json")
        .setStatusCode(HttpResponseStatus.OK.code())
        .end(Json.encodePrettily(response));
      ignored.span().log("request ended");
      ignored.span().log("request ended");
    }
  }

  public void singleUserHandler(RoutingContext routingContext) {
    try (Scope ignored = tracer.buildSpan(getSingleUserOperation).startActive(true)) {
      String userName = routingContext.request().getParam("name");
      MultiMap params = routingContext.request().params();
      UUID uuid = Utils.getUUID();
      ignored.span().log("request started");
      JsonArray data = new JsonArray();
      data.add(12123);
      data.add(12124);
      data.add(12356);
      JsonObject response = new JsonObject()
        .put("status", "ok")
        .put("data", data)
        .put("message", "");
      routingContext.response()
        .putHeader("content-type", "application/json")
        .setStatusCode(HttpResponseStatus.OK.code())
        .end(Json.encodePrettily(response));
      ignored.span().log("request ended");
    }
  }

  public void sessionHandler(RoutingContext routingContext) {
    try (Scope ignored = tracer.buildSpan(getSessionOperation).startActive(true)) {
      String userName = routingContext.request().getParam("name");
      String sessionId = routingContext.request().getParam("session");
      MultiMap params = routingContext.request().params();
      UUID uuid = Utils.getUUID();
      ignored.span().log("request started");
      JsonArray data = new JsonArray();
      data.add(new JsonObject("{\"key\":\"value0\"}"));
      data.add(new JsonObject("{\"key\":\"value1\"}"));
      JsonObject response = new JsonObject()
        .put("status", "ok")
        .put("data", data)
        .put("message", "");
      routingContext.response()
        .putHeader("content-type", "application/json")
        .setStatusCode(HttpResponseStatus.OK.code())
        .end(Json.encodePrettily(response));
      ignored.span().log("request ended");
    }
  }


  @Override
  public void start(Future<Void> fut) {
    spanMap = Utils.getSpanMap();
    tracer = Utils.buildTracer("Rest v2");
    router = Utils.getRouter();
    router.get("/users").handler(this::usersHandler);
    router.get("/user/:name").handler(this::singleUserHandler);
    router.get("/user/:name/session/:session").handler(this::sessionHandler);
  }
}
