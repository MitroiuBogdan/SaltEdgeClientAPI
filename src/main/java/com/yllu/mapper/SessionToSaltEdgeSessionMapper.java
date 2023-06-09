package com.yllu.mapper;

import com.yllu.client.rest.client.request.SaltEdgeConsent;
import com.yllu.client.rest.client.request.connect.SessionRequestSaltEdge;
import com.yllu.resource.ais.requests.InitiateSessionRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Component
public class SessionToSaltEdgeSessionMapper {

    public Optional<SessionRequestSaltEdge> mapTo(InitiateSessionRequest source) {
        if (source == null) {
            return Optional.empty();
        }
        SessionRequestSaltEdge target = SessionRequestSaltEdge.builder()
                .customerId(source.getCustomerId())
                .connectionId(source.getConnectionId())
                .providerCode(source.getAspspCode())
                .dailyRefresh(source.getDailyRefresh())
                .consent(SaltEdgeConsent.builder()
                        .scopes(List.of("account_details", "transactions_details"))
                        .build())
//                .attempt(SaltEdgeAttemptRequest.builder()
//                        .returnTo(source.getReturnBackUrl())
//                        .build())
                .build();

        return Optional.of(target);
    }
}
