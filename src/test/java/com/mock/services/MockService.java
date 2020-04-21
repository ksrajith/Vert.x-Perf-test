package com.mock.services;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import sun.security.provider.certpath.Vertex;

public class MockService {

    public MockService(Router router){
        router.post("/api/test").produces("application/json").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            String body="{\n" +
                    "\t\"name\": \"Task 5\",\n" +
                    "\t\"category\": \"R&D\",\n" +
                    "\t\"status\": \"Completed\",\n" +
                    "\t\"createdDate\": \"2019-07-11T04:06:44.110Z\"\n" +
                    "}";
            JsonObject json = new JsonObject(body);
            response.putHeader("content-type", "application/json; charset=utf-8")
                .setStatusCode(200)
                    .end(Json.encodePrettily(json));

        });
    }

}
