package com.yllu.vendor.saltedge.rest.client;

import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeAttemptRequest;
import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeRequest;
import com.yllu.vendor.saltedge.rest.client.request.enrichment.MerchantsInfoRequest;
import com.yllu.vendor.saltedge.rest.client.request.oauth.CreateOauthConnectionRequestDataSaltEdge;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeListResponse;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeResponse;
import com.yllu.vendor.saltedge.rest.client.response.ais.*;
import com.yllu.vendor.saltedge.rest.client.response.connect.SessionData;
import com.yllu.vendor.saltedge.rest.client.response.enrichment.MerchantInfo;
import com.yllu.vendor.saltedge.rest.client.response.oauth.CreateOauthConnectionSaltEdgeResponseData;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaltEdgeClient {

    //SaltEdge Connect
    Mono<SaltEdgeResponse<SessionData>> createSaltEdgeSession(SaltEdgeRequest requestBody);

    Mono<SaltEdgeResponse<SessionData>> refreshSaltEdgeSession(SaltEdgeRequest requestBody);

    Mono<SaltEdgeResponse<SessionData>> reconnectSaltEdgeSession(SaltEdgeRequest requestBody);


    // Oauth connection
    Mono<SaltEdgeResponse<CreateOauthConnectionSaltEdgeResponseData>> createOauthConnection(SaltEdgeRequest<CreateOauthConnectionRequestDataSaltEdge> requestBody);

    //Aggregation
    Flux<SaltedgeAccount> getAccounts(String connectionId);

    Flux<SaltedgeTransaction> getTransactions(String connectionId, String accountId);

    Mono<SaltEdgeResponse<SaltedgeConnection>> refreshConnectionById(String connectionId, SaltEdgeRequest<SaltEdgeAttemptRequest> requestBody);

    Mono<SaltEdgeResponse<SaltedgeDeleteResponse>> deleteConnectionById(String connectionId);

    Mono<SaltEdgeResponse<SaltedgeConnection>> getById(String connectionId);

    Mono<SaltEdgeResponse<SaltEdgeCustomer>> createCustomer(SaltEdgeRequest requestBody);

    Mono<ResponseEntity<Void>> deleteCustomer(String userId);

    Flux<SaltEdgeCustomer> getAllCustomers();

    Mono<SaltEdgeResponse<SaltEdgeCustomer>> getCustomerById(String userId);

    Mono<SaltEdgeResponse<SaltedgeProvider>> getAspspByProviderCode(String providerAspspId);

    Flux<SaltEdgeListResponse<SaltedgeProvider>> getAspsps();

    //Enrichment
    Flux<MerchantInfo> getMerchantsInfo(MerchantsInfoRequest request);
}
