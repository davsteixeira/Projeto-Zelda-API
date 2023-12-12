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
                .route("usuarios", r -> r.path("/api/users/get")
                        .uri("http://localhost:8081"))
                .route("usuarioID", r -> r.path("/api/users/*")
                        .filters(f -> f.rewritePath("/<id>.*", "/${id}"))
                        .uri("http://localhost:8081"))
                .route("cadastrarUsuarios", r -> r.path("/api/users/save")
                        .uri("http://localhost:8081"))
                .route("atualizarusuario", r -> r.path("/api/users/update/*")
                        .filters(f -> f.rewritePath("/<id>.*", "/${id}"))
                        .uri("http://localhost:8081"))
                .route("deletarUsuario", r -> r.path("/api/users/delete/*")
                        .filters(f -> f.rewritePath("/<id>.*", "/${id}"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
