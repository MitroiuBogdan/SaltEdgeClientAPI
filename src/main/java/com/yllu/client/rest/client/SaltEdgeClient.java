package com.yllu.client.rest.client;

import com.yllu.client.rest.client.request.SaltEdgeAttemptRequest;
import com.yllu.client.rest.client.request.SaltEdgeRequest;
import com.yllu.client.rest.client.response.SaltEdgeListResponse;
import com.yllu.client.rest.client.response.SaltEdgeResponse;
import com.yllu.client.rest.client.response.ais.*;
import com.yllu.client.rest.client.response.connect.SessionData;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaltEdgeClient {

    //SaltEdge Connect
    Mono<SaltEdgeResponse<SessionData>> createSaltEdgeSession(SaltEdgeRequest requestBody);

    Mono<SaltEdgeResponse<SessionData>> refreshSaltEdgeSession(SaltEdgeRequest requestBody);

    Mono<SaltEdgeResponse<SessionData>> reconnectSaltEdgeSession(SaltEdgeRequest requestBody);

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

}
