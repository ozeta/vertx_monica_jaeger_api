package eta.oz.monica_api;


import io.jaegertracing.Configuration;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Utils {

  private static Logger logger;
  private static Tracer tracer;
  private static Vertx vertx;
  private static Map<UUID, Span> spanMap;
  private static Map<UUID, Object> map;
  private static Router router;

  private Utils() {
  }

  public static Logger getLogger(Class instance) {
    if (logger == null) logger = LoggerFactory.getLogger(instance);
    return logger;
  }

  public static Tracer buildTracer(String serviceName) {
    Configuration config = new Configuration(serviceName);
    // Get the actual OpenTracing-compatible Tracer.
    Tracer tracer = config.getTracer();
    if (tracer == null) throw new RuntimeException("TRACER runtime exception for <" + serviceName + ">");
    return tracer;
  }

  public static Tracer getTracer() {
    Configuration config = new Configuration("vertx-service");

    // Get the actual OpenTracing-compatible Tracer.
    Tracer tracer = config.getTracer();

    if (tracer == null) throw new RuntimeException("TRACER runtime exception");
    return tracer;
  }

  public static Vertx getVerx() {
    if (vertx == null) vertx = Vertx.vertx();
    return vertx;
  }

  public static Map<UUID, Span> getSpanMap() {
    if (spanMap == null) spanMap = new HashMap<>();
    return spanMap;
  }

  public static Map<UUID, Object> getMap() {
    if (map == null) map = new HashMap<>();
    return map;
  }

  public static UUID getUUID() {
    return UUID.randomUUID();
  }

  public static Router getRouter() {
    if (router == null) router = Router.router(vertx);
    return router;
  }
}
