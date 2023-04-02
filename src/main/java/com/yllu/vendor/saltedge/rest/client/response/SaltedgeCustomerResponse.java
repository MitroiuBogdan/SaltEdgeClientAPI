package com.yllu.vendor.saltedge.rest.client.response;

import com.yllu.vendor.saltedge.rest.client.response.ais.SaltEdgeCustomer;

import java.util.List;

public class SaltedgeCustomerResponse extends SaltEdgeListResponse<SaltEdgeCustomer> {
    public SaltedgeCustomerResponse(List<SaltEdgeCustomer> data) {
        super(data);
    }

    public SaltedgeCustomerResponse() {
        super();
    }
}
