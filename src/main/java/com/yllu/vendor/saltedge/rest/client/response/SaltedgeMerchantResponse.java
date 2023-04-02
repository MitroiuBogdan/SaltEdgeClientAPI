package com.yllu.vendor.saltedge.rest.client.response;

import com.yllu.vendor.saltedge.rest.client.response.enrichment.MerchantInfo;

import java.util.List;

public class SaltedgeMerchantResponse extends SaltEdgeListResponse<MerchantInfo> {
    public SaltedgeMerchantResponse(List<MerchantInfo> data) {
        super(data);
    }

    public SaltedgeMerchantResponse() {
        super();
    }
}
