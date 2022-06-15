package com.nhnacademy.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskRouteConfig {
    @Bean
    public RouteLocator accountRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/account/**")
                        .uri("http://localhost:9090"))
                .build();
    }

    @Bean
    public RouteLocator projectRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/project/**")
                        .uri("http://localhost:9999"))
                .build();
    }
}
