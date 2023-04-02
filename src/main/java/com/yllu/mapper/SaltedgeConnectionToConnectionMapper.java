package com.yllu.mapper;

import com.yllu.client.rest.client.response.ais.SaltedgeConnection;
import com.yllu.domain.Connection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaltedgeConnectionToConnectionMapper implements Function<SaltedgeConnection, Connection> {

    public static SaltedgeConnectionToConnectionMapper SALTEDGE_CONNECTION_TO_CONNECTION_MAPPER = new SaltedgeConnectionToConnectionMapper();

    @Override
    public Connection apply(SaltedgeConnection saltedgeConnection) {
        return Connection.builder()
                .connectionId(saltedgeConnection.getId())
                .status(saltedgeConnection.getStatus())
                .reason(saltedgeConnection.getLastAttempt().getFailMessage())
                .build();
    }
}
