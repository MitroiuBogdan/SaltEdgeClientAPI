package com.yllu.vendor.saltedge.service;

import com.yllu.common.domain.entity.Aspsp;
import com.yllu.vendor.saltedge.rest.client.SaltEdgeClient;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeListResponse;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeResponse;
import com.yllu.vendor.saltedge.mapper.SaltedgeAspspMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class SaltedgeAspspService {

    private SaltEdgeClient saltEdgeClient;

    public Mono<Aspsp> getByProviderCode(String providerCode) {
        return saltEdgeClient.getAspspByProviderCode(providerCode)
                .map(SaltEdgeResponse::getData)
                .map(SaltedgeAspspMapper.SALTEDGE_ASPSP_MAPPER);
    }

    public Flux<Aspsp> getAspsps() {
        return saltEdgeClient.getAspsps()
                .flatMapIterable(SaltEdgeListResponse::getData)
                .map(SaltedgeAspspMapper.SALTEDGE_ASPSP_MAPPER);
    }
}
