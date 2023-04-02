package com.yllu.vendor.saltedge.mapper;

import com.yllu.client.rest.client.response.ais.SaltedgeConnection;
import com.yllu.domain.Connection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaltedgeConnectionToGrantMapper implements Function<SaltedgeConnection, Connection> {

    public static SaltedgeConnectionToGrantMapper SALTEDGE_CONNECTION_TO_GRANT_MAPPER = new SaltedgeConnectionToGrantMapper();

    @Override
    public Connection apply(SaltedgeConnection saltedgeConnection) {
        return Connection.builder()
                .connectionId(saltedgeConnection.getId())
                .lastRefreshTimestampProvider(saltedgeConnection.getUpdatedAt())
                .providerStatus(saltedgeConnection.getStatus())
                .providerReason(saltedgeConnection.getLastAttempt().getFailMessage())
                .build();
    }
}
