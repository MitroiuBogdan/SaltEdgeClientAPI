package com.yllu.vendor.saltedge.service;

import com.yllu.common.domain.entity.Grant;
import com.yllu.vendor.saltedge.rest.client.SaltEdgeClient;
import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeAttemptRequest;
import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeRequest;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeResponse;
import com.yllu.vendor.saltedge.rest.client.response.ais.SaltedgeDeleteResponse;
import com.yllu.vendor.saltedge.mapper.SaltedgeConnectionToGrantMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class SaltedgeConnectionService {

    private final SaltEdgeClient saltEdgeClient;

    public Mono<Grant> refreshById(String connectionId) {
        SaltEdgeAttemptRequest attempt = SaltEdgeAttemptRequest.builder()
                .fetchScopes(List.of("accounts", "transactions"))
                .build();
        return saltEdgeClient.refreshConnectionById(connectionId, new SaltEdgeRequest<>(attempt))
                .doOnNext(refreshResponse -> log.info("refreshById - refresh succeeded for connection {}", refreshResponse.getData()))
                .map(refreshResponse -> SaltedgeConnectionToGrantMapper.SALTEDGE_CONNECTION_TO_GRANT_MAPPER.apply(refreshResponse.getData()));
    }

    public Mono<SaltedgeDeleteResponse> deleteById(String connectionId) {
        return saltEdgeClient.deleteConnectionById(connectionId)
                .doOnNext(deleteResponse -> log.info("deleteById - deletion succeeded for connection {}", connectionId))
                .map(SaltEdgeResponse::getData);
    }

    public Mono<Grant> getById(String connectionId) {
        return saltEdgeClient.getById(connectionId)
                .map(SaltEdgeResponse::getData)
                .doOnNext(saltedgeConnection -> log.info("getById - received connection from saltedge: {}", saltedgeConnection))
                .map(SaltedgeConnectionToGrantMapper.SALTEDGE_CONNECTION_TO_GRANT_MAPPER);

    }
}
