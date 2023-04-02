package com.yllu.vendor.saltedge.rest.client.request;

import com.yllu.vendor.saltedge.rest.client.request.connect.SessionRequestSaltEdge;
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
