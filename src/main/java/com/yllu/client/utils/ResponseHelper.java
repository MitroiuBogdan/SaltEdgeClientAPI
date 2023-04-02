package com.yllu.client.utils;

import com.yllu.client.rest.client.response.SaltEdgeListResponse;
import reactor.core.publisher.Flux;

public interface ResponseHelper {

    static <T> Flux<T> getFluxFromData(SaltEdgeListResponse<T> response) {
        return Flux.fromIterable(response.getData());
    }
}
