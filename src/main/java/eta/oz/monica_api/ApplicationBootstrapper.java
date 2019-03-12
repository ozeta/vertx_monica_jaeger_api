package eta.oz.monica_api;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;


public class ApplicationBootstrapper {
  private static Logger logger = Utils.getLogger(MethodHandles.lookup().lookupClass());

  public static void main(String[] args) {
    Vertx vertx = Utils.getVerx();
    String serviceName = System.getenv("MONICA_REST_SERVICE");
    if (null == serviceName || serviceName.isEmpty()) {
      serviceName = "vertx-trace-demo";
    }

    System.setProperty("MONICA_REST_SERVICE", serviceName);
    logger.info("Starting OpenTracing demo");

    Router router = Utils.getRouter();
    Verticle v1restVerticle = new eta.oz.monica_api.v1.V1RestVerticle();
    Verticle v2restVerticle = new eta.oz.monica_api.v2.RestVerticle();

    vertx
      .createHttpServer()
      .requestHandler(router)
      .listen(
        5050,
        result -> {
          if (result.succeeded()) {
            logger.info("deployed");
          } else {
            throw new RuntimeException(result.cause());
          }
        }
      );


    vertx.deployVerticle(v2restVerticle);
    vertx.deployVerticle(v1restVerticle);

  }
}
