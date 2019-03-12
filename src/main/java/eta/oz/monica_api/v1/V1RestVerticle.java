package eta.oz.monica_api.v1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import eta.oz.monica_api.Utils;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
public class V1RestVerticle extends AbstractVerticle {
  private Logger logger = Utils.getLogger(MethodHandles.lookup().lookupClass());
  private Tracer tracer;
  private String getOperation = "GET /getpy.php";
  private String getSingleUserOperation = "GET /getpy.php?user=:user";
  private String getSingleUserLastOperation = "GET /getpy.php?user=:user&max";
  private String getUsersSortedOperation = "GET /getpy.php?usersorted";
  private String getSessionOperation = "GET /getpy.php?user=:user&session:session";
  private String getSessionCsvOperation = "GET /getpy.php?user=:user&session:session&csv";
  private Map<UUID, Span> spanMap;
  private int port = 5050;
  private Router router;

  public void getpyHandler(RoutingContext routingContext) {
    try (Scope ignored = tracer.buildSpan(getOperation).startActive(true)) {
      MultiMap params = routingContext.request().params();
      String usersorted = params.get("usersorted");
      String user = params.get("user");
      String session = params.get("session");
      String csv = params.get("csv");
      String max = params.get("max");

      if (usersorted != null) {
        handleUserSorted(routingContext, ignored);
        return;
      }
      if (user != null && max != null) {
        handleUserLastSession(routingContext, ignored, user, max);
        return;
      } else if (user != null && session != null && csv != null) {
        handleSessionCsv(routingContext, ignored, user, session, csv);
        return;
      } else if (user != null && session != null) {
        handleUserSession(routingContext, ignored, user, session);
        return;
      } else if (user != null) {
        handleCurrentUser(routingContext, ignored, user);
        return;
      }
    }
  }

  private void handleCurrentUser(RoutingContext routingContext, Scope inner, String user) {
    try (final Scope pongHandleScope = tracer.buildSpan(getSingleUserOperation).asChildOf(inner.span()).startActive(true)) {
      logger.info("handling handleCurrentUser");
      handleRequest(routingContext, inner, "http://cicala.portici.enea.it/rest/getpy.php?user=" + user);
    }
  }

  private void handleUserSorted(RoutingContext routingContext, Scope inner) {
    try (final Scope pongHandleScope = tracer.buildSpan(getUsersSortedOperation).asChildOf(inner.span()).startActive(true)) {
      logger.info("handling handleUserSorted");
      handleRequest(routingContext, inner, "http://cicala.portici.enea.it/rest/getpy.php?usersorted=");
    }
  }

  private void handleUserLastSession(RoutingContext routingContext, Scope inner, String user, String max) {
    try (final Scope pongHandleScope = tracer.buildSpan(getSingleUserLastOperation).asChildOf(inner.span()).startActive(true)) {
      logger.info("handling handleUserLastSession");
      handleRequest(routingContext, inner, "http://cicala.portici.enea.it/rest/getpy.php?user=" + user + "&max");
    }
  }


  private void handleUserSession(RoutingContext routingContext, Scope inner, String user, String session) {
    try (final Scope pongHandleScope = tracer.buildSpan(getSessionOperation).asChildOf(inner.span()).startActive(true)) {
      logger.info("handling handleUserSession");
      handleRequest(routingContext, inner, "http://cicala.portici.enea.it/rest/getpy.php?user=" + user + "&session=" + session);
    }
  }

  private void handleSessionCsv(RoutingContext routingContext, Scope inner, String user, String session, String csv) {
    try (final Scope pongHandleScope = tracer.buildSpan(getSessionCsvOperation).asChildOf(inner.span()).startActive(true)) {
      logger.info("handling handleSessionCsv");
      handleRequest(routingContext, inner, "http://cicala.portici.enea.it/rest/getpy.php?user=" + user + "&session=" + session + "&csv");
    }
  }


  private void handleRequest(RoutingContext routingContext, Scope inner, String url) {
    AtomicInteger code = new AtomicInteger(HttpResponseStatus.OK.code());
    StringBuilder response = new StringBuilder();
    StringBuilder contentType = new StringBuilder();
    vertx.executeBlocking(future -> {
      try {
        HttpResponse<String> stringHttpResponse = Unirest.get(url).asString();
        future.complete(stringHttpResponse);
      } catch (Exception e) {
        e.printStackTrace();
        code.set(HttpResponseStatus.INTERNAL_SERVER_ERROR.code());
        future.fail(e.getMessage());
      }
    }, res -> {
      if (res.succeeded()) {
        HttpResponse<String> restResponse = (HttpResponse<String>) res.result();
        if (restResponse.getStatus() == 200) {
          Optional<String> contenttype = restResponse.getHeaders().entrySet().stream()
            .filter(f -> f.getKey().equalsIgnoreCase("content-type")).findFirst().map(m -> m.getValue().get(0));
          contentType.append(contenttype.orElse("text/plain"));
          response.append(restResponse.getBody());
        }
      } else {
        code.set(HttpResponseStatus.INTERNAL_SERVER_ERROR.code());
        response.append("internal server error" + res.cause().getMessage());
        contentType.append("text/plain");
      }
      routingContext.response()
        .putHeader("content-type", contentType.toString())
        .setStatusCode(code.get())
        .end(response.toString());
      logger.info("request terminated");
    });
  }

  @Override
  public void start(Future<Void> fut) {
    spanMap = Utils.getSpanMap();
    tracer = Utils.buildTracer("Rest v1");
    router = Utils.getRouter();
    router.get("/rest/getpy.php").handler(this::getpyHandler);
  }

  @Override
  public void stop(Future<Void> stopFuture) throws Exception {
    Unirest.shutdown();
    super.stop(stopFuture);
  }
}
