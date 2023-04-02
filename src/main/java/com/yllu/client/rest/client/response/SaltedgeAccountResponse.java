package com.yllu.client.rest.client.response;

import com.yllu.client.rest.client.response.ais.SaltedgeAccount;

import java.util.List;

public class SaltedgeAccountResponse extends SaltEdgeListResponse<SaltedgeAccount> {

    public SaltedgeAccountResponse(List<SaltedgeAccount> data) {
        super(data);
    }

    public SaltedgeAccountResponse() {
        super();
    }
}
