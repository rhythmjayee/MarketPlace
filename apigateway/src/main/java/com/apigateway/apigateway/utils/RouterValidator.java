package com.apigateway.apigateway.utils;

import java.util.List;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/login"
    );

    public boolean isSecured(ServerHttpRequest request) {
        return openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
    }
}
