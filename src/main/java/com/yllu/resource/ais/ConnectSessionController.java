package com.yllu.resource.ais;


import com.yllu.resource.ais.requests.InitiateSessionRequest;
import com.yllu.mapper.SessionToSaltEdgeSessionMapper;
import com.yllu.client.rest.client.SaltEdgeClientImpl;
import com.yllu.client.rest.client.request.SaltEdgeRequest;
import com.yllu.client.rest.client.response.SaltEdgeResponse;
import com.yllu.client.rest.client.response.connect.SessionData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("session")
public class ConnectSessionController {

    private final SaltEdgeClientImpl saltEdgeClient;
    private final SessionToSaltEdgeSessionMapper toCreateSaltEdgeSession;

    @PostMapping("/create")
    public Mono<SessionData> createSession(@RequestBody InitiateSessionRequest request) {
        log.info("createSession - Creating session using request: {}", request.toString());

        SaltEdgeRequest seRequest = toCreateSaltEdgeSession
                .mapTo(request)
                .map(SaltEdgeRequest::new)
                .orElse(null);

        return saltEdgeClient.createSaltEdgeSession(seRequest)
                .map(SaltEdgeResponse::getData);
    }

    @PutMapping("/reconnect")
    public Mono<SessionData> reconnectSession(@RequestBody InitiateSessionRequest request) {
        log.info("reconnectSession - Reconnecting session using request: {}", request.toString());

        SaltEdgeRequest seRequest = toCreateSaltEdgeSession
                .mapTo(request)
                .map(SaltEdgeRequest::new)
                .orElse(null);

        return saltEdgeClient.reconnectSaltEdgeSession(seRequest)
                .map(SaltEdgeResponse::getData);

    }

    @PutMapping("/refresh")
    public Mono<SessionData> refreshSession(@RequestBody InitiateSessionRequest request) {
        log.info("refreshSession - Refreshing session using request: {}", request.toString());

        SaltEdgeRequest seRequest = toCreateSaltEdgeSession
                .mapTo(request)
                .map(SaltEdgeRequest::new)
                .orElse(null);

        return saltEdgeClient.refreshSaltEdgeSession(seRequest)
                .map(SaltEdgeResponse::getData);
    }

}
