package com.yllu.vendor.saltedge.service;

import com.yllu.vendor.saltedge.rest.client.SaltEdgeClient;
import com.yllu.vendor.saltedge.rest.client.request.oauth.CreateOauthConnectionRequest;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeResponse;
import com.yllu.vendor.saltedge.rest.client.response.oauth.CreateOauthConnectionSaltEdgeResponseData;
import com.yllu.vendor.saltedge.mapper.CreateOauthConnectionRequestMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class SaltedgeOauthConnectionService {

    private final SaltEdgeClient saltEdgeClient;

    public Mono<SaltEdgeResponse<CreateOauthConnectionSaltEdgeResponseData>> createConnection(CreateOauthConnectionRequest request) {
        return saltEdgeClient.createOauthConnection(CreateOauthConnectionRequestMapper.CREATE_OAUTH_CONNECTION_REQUEST_MAPPER.apply(request));
    }
}
