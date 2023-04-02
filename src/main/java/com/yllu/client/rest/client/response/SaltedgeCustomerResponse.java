package com.yllu.client.rest.client.response;

import com.yllu.client.rest.client.response.ais.SaltEdgeCustomer;

import java.util.List;

public class SaltedgeCustomerResponse extends SaltEdgeListResponse<SaltEdgeCustomer> {
    public SaltedgeCustomerResponse(List<SaltEdgeCustomer> data) {
        super(data);
    }

    public SaltedgeCustomerResponse() {
        super();
    }
}
