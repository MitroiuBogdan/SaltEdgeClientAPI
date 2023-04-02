package com.yllu.service;


import com.yllu.client.rest.client.SaltEdgeClient;
import com.yllu.client.rest.client.request.SaltEdgeAttemptRequest;
import com.yllu.client.rest.client.request.SaltEdgeRequest;
import com.yllu.client.rest.client.response.SaltEdgeResponse;
import com.yllu.client.rest.client.response.ais.SaltedgeDeleteResponse;
import com.yllu.domain.Connection;
import com.yllu.mapper.SaltedgeConnectionToConnectionMapper;
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

    public Mono<Connection> refreshById(String connectionId) {
        SaltEdgeAttemptRequest attempt = SaltEdgeAttemptRequest.builder()
                .fetchScopes(List.of("accounts", "transactions"))
                .build();
        return saltEdgeClient.refreshConnectionById(connectionId, new SaltEdgeRequest<>(attempt))
                .doOnNext(refreshResponse -> log.info("refreshById - refresh succeeded for connection {}", refreshResponse.getData()))
                .map(refreshResponse -> SaltedgeConnectionToConnectionMapper.SALTEDGE_CONNECTION_TO_CONNECTION_MAPPER.apply(refreshResponse.getData()));
    }

    public Mono<SaltedgeDeleteResponse> deleteById(String connectionId) {
        return saltEdgeClient.deleteConnectionById(connectionId)
                .doOnNext(deleteResponse -> log.info("deleteById - deletion succeeded for connection {}", connectionId))
                .map(SaltEdgeResponse::getData);
    }

    public Mono<Connection> getById(String connectionId) {
        return saltEdgeClient.getById(connectionId)
                .map(SaltEdgeResponse::getData)
                .doOnNext(saltedgeConnection -> log.info("getById - received connection from saltedge: {}", saltedgeConnection))
                .map(SaltedgeConnectionToConnectionMapper.SALTEDGE_CONNECTION_TO_CONNECTION_MAPPER);

    }
}
