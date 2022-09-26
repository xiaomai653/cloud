package com.springcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xiaomai
 * @date 2022/5/21
 */
@Component
public class TokenGatewayFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 前置过滤器pre
        System.out.println("TokenGatewayFilter filtered!--PRE");
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    // 后置过滤器post
                    System.out.println("TokenGatewayFilter filtered!--POST");
                })
        );
//        System.out.println("自定义过滤器......");
//        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 20;
    }

    @Configuration
    class RouteConfiguration {
        @Bean
        public RouteLocator routeLocator(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route("myFilter", r -> r.path("/myFilter/**")
                            .filters(f -> f.stripPrefix(1)
                                    .filters(new TokenGatewayFilter()))
                            .uri("lb://consumer"))
                    .build();

        }
    }
}
