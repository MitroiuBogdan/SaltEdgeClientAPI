package com.yllu.vendor.saltedge.mapper;

import com.yllu.common.domain.entity.Grant;
import com.yllu.vendor.saltedge.rest.client.response.ais.SaltedgeConnection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaltedgeConnectionToGrantMapper implements Function<SaltedgeConnection, Grant> {

    public static SaltedgeConnectionToGrantMapper SALTEDGE_CONNECTION_TO_GRANT_MAPPER = new SaltedgeConnectionToGrantMapper();

    @Override
    public Grant apply(SaltedgeConnection saltedgeConnection) {
        return Grant.builder()
                .providerGrantId(saltedgeConnection.getId())
                .lastRefreshTimestampProvider(saltedgeConnection.getUpdatedAt())
                .providerStatus(saltedgeConnection.getStatus())
                .providerReason(saltedgeConnection.getLastAttempt().getFailMessage())
                .build();
    }
}
