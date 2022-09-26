package com.springcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * @author xiaomai
 * @date 2022/5/21
 */
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // 获取过滤器的配置属性

        return (exchange, chain) -> {
            // 前置过滤器pre
            System.out.println("TokenGatewayFilterFactory filtered!--PRE");
            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            // 后置过滤器post
            System.out.println("TokenGatewayFilterFactory filtered!--POST");
            return chain.filter(exchange.mutate().request(builder.build()).build());
//            System.out.println("自定义过滤器......");
//            return chain.filter(exchange);
        };
    }

    public static class Config {
        // 将过滤器的配置属性放这里
    }

}
