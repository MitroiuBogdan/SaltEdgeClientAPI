package com.yllu.common.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.WebFilter;

@Configurable
@Slf4j
public class LogConfiguration {

    @Bean
    public WebFilter logFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("Received request: {} {}", request.getMethodValue(), request.getPath().value());
            return chain.filter(exchange);
        };
    }
}
