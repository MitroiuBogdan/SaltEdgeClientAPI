package com.yllu.vendor.saltedge.rest.controllers;

import com.yllu.vendor.saltedge.rest.client.request.oauth.CreateOauthConnectionRequest;
import com.yllu.vendor.saltedge.rest.client.response.oauth.CreateOauthConnectionResponse;
import com.yllu.vendor.saltedge.service.SaltedgeOauthConnectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.yllu.vendor.saltedge.mapper.CreateOauthConnectionResponseMapper.CREATE_OAUTH_CONNECTION_RESPONSE_MAPPER;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/saltedge/oauth")
public class OauthConnectionController {

    private SaltedgeOauthConnectionService oauthConnectionService;

    @PostMapping("/create")
    public Mono<CreateOauthConnectionResponse> createConnection(@RequestBody CreateOauthConnectionRequest request) {
        log.info("createGrant - create oauth grant for request {}", request.toString());
        return oauthConnectionService.createConnection(request)
                .map(CREATE_OAUTH_CONNECTION_RESPONSE_MAPPER);
    }

}
