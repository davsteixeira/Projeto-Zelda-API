package com.github.gatewayApi.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConf {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("webclient", r -> r.path("/api/games")
                    .uri("http://localhost:8082"))
                .route("webclientID", r-> r.path("/api/games/*")
                        .filters(f -> f.rewritePath("/<id>.*", "/${id}*"))
                        .uri("http://localhost:8082"))
                .build();


    }
}
