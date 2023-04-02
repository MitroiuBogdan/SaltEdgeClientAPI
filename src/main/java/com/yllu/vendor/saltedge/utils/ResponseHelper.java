package com.yllu.vendor.saltedge.utils;

import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeListResponse;
import reactor.core.publisher.Flux;

public interface ResponseHelper {

    static <T> Flux<T> getFluxFromData(SaltEdgeListResponse<T> response) {
        return Flux.fromIterable(response.getData());
    }
}
