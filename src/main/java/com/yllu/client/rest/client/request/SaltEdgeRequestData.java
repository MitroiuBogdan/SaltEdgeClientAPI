package com.yllu.client.rest.client.request;

import com.yllu.client.rest.client.request.connect.SessionRequestSaltEdge;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaltEdgeRequestData {

    private SessionRequestSaltEdge data;

    public SaltEdgeRequestData(SessionRequestSaltEdge data) {
        this.data = data;
    }
}
