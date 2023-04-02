package com.yllu.client.rest.client.response;

import com.yllu.client.rest.client.response.ais.SaltedgeTransaction;

import java.util.List;

public class SaltedgeTransactionResponse extends SaltEdgeListResponse<SaltedgeTransaction> {
    public SaltedgeTransactionResponse(List<SaltedgeTransaction> data) {
        super(data);
    }

    public SaltedgeTransactionResponse() {
        super();
    }
}
