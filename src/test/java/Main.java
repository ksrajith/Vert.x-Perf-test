import com.mock.services.MockService;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.handler.BodyHandler;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();
        io.vertx.ext.web.Router router = io.vertx.ext.web.Router.router(vertx);
        router.route().handler(BodyHandler.create());
        // you can change the port here
        httpServer.requestHandler(router::accept).listen(3030);
         // you can put your constructor here
        MockService ms = new MockService(router);

    }


}
