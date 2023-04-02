package com.yllu.vendor.saltedge.rest.client;

import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeAttemptRequest;
import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeRequest;
import com.yllu.vendor.saltedge.rest.client.request.enrichment.MerchantsInfoRequest;
import com.yllu.vendor.saltedge.rest.client.request.oauth.CreateOauthConnectionRequestDataSaltEdge;
import com.yllu.vendor.saltedge.rest.client.response.*;
import com.yllu.vendor.saltedge.rest.client.response.ais.*;
import com.yllu.vendor.saltedge.rest.client.response.connect.SessionData;
import com.yllu.vendor.saltedge.rest.client.response.enrichment.MerchantInfo;
import com.yllu.vendor.saltedge.rest.client.response.oauth.CreateOauthConnectionSaltEdgeResponseData;
import com.yllu.vendor.saltedge.utils.ResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

import static java.util.Optional.ofNullable;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Service
@RequiredArgsConstructor
public class SaltEdgeClientImpl implements SaltEdgeClient {

    private static final String SALTEDGE_ACCOUNT_PATH = "v5/accounts";
    private static final String SALTEDGE_TRASACTION_PATH = "v5/transactions";
    private static final String SALTEDGE_CONNECT_PATH = "v5/connect_sessions";
    private static final String SALTEDGE_OAUTH_PATH = "/v5/oauth_providers";
    private static final String SALTEDGE_CONNECTIONS_PATH = "/v5/connections";
    private static final String SALTEDGE_CUSTOMER_PATH = "/v5/customers";
    private static final String SALTEDGE_PROVIDER_PATH = "/v5/providers";
    private static final String SALTEDGE_MERCHANT_PATH = "/v5/merchants";
    private static final String SALTEDGE_ENRICHMENT_PATH = "/v5/enrichment";

    private final WebClient webClient;

    @Override
    public Mono<SaltEdgeResponse<SessionData>> createSaltEdgeSession(SaltEdgeRequest requestBody) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CONNECT_PATH + "/create")
                        .build())
                .body(fromValue(requestBody))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SessionData>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<SessionData>> refreshSaltEdgeSession(SaltEdgeRequest requestBody) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CONNECT_PATH + "/refresh")
                        .build())
                .body(fromValue(requestBody))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SessionData>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<SessionData>> reconnectSaltEdgeSession(SaltEdgeRequest requestBody) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CONNECT_PATH + "/reconnect")
                        .build())
                .body(fromValue(requestBody))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SessionData>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<CreateOauthConnectionSaltEdgeResponseData>> createOauthConnection(SaltEdgeRequest<CreateOauthConnectionRequestDataSaltEdge> requestBody) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_OAUTH_PATH + "/create")
                        .build())
                .body(fromValue(requestBody))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<CreateOauthConnectionSaltEdgeResponseData>>() {
                });
    }


    @Override
    public Flux<SaltedgeAccount> getAccounts(String connectionId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(SALTEDGE_ACCOUNT_PATH)
                        .queryParam("connection_id", connectionId).build())
                .retrieve()
                .bodyToMono(SaltedgeAccountResponse.class)
                .flatMapMany(ResponseHelper::getFluxFromData);
    }

    @Override
    public Flux<SaltedgeTransaction> getTransactions(String connectionId, String accountId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(SALTEDGE_TRASACTION_PATH)
                        .queryParam("connection_id", connectionId)
                        .queryParamIfPresent("account_id", ofNullable(accountId))
                        .build())
                .retrieve().bodyToMono(SaltedgeTransactionResponse.class)
                .flatMapMany(ResponseHelper::getFluxFromData);
    }

    @Override
    public Mono<SaltEdgeResponse<SaltedgeConnection>> refreshConnectionById(String connectionId, SaltEdgeRequest<SaltEdgeAttemptRequest> requestBody) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CONNECTIONS_PATH + "/" + connectionId + "/refresh")
                        .build())
                .body(fromValue(requestBody))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SaltedgeConnection>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<SaltedgeDeleteResponse>> deleteConnectionById(String connectionId) {
        return webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CONNECTIONS_PATH + "/" + connectionId)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SaltedgeDeleteResponse>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<SaltedgeConnection>> getById(String connectionId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CONNECTIONS_PATH + "/" + connectionId)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SaltedgeConnection>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<SaltEdgeCustomer>> createCustomer(SaltEdgeRequest requestBody) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CUSTOMER_PATH)
                        .build())
                .body(fromValue(requestBody))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SaltEdgeCustomer>>() {
                });
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCustomer(String userId) {
        return webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_CUSTOMER_PATH + "/" + userId)
                        .build())
                .retrieve()
                .toBodilessEntity();
    }

    @Override
    public Flux<SaltEdgeCustomer> getAllCustomers() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(SALTEDGE_CUSTOMER_PATH)
                        .build())
                .retrieve().bodyToMono(SaltedgeCustomerResponse.class)
                .flatMapMany(ResponseHelper::getFluxFromData);
    }

    @Override
    public Mono<SaltEdgeResponse<SaltEdgeCustomer>> getCustomerById(String userId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(SALTEDGE_CUSTOMER_PATH + "/" + userId)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SaltEdgeCustomer>>() {
                });
    }

    @Override
    public Mono<SaltEdgeResponse<SaltedgeProvider>> getAspspByProviderCode(String providerCode) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(SALTEDGE_PROVIDER_PATH + "/" + providerCode)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeResponse<SaltedgeProvider>>() {
                });
    }

    @Override
    public Flux<SaltEdgeListResponse<SaltedgeProvider>> getAspsps() {
        AtomicReference<String> nextId = new AtomicReference<>("0");
        return Mono.defer(() -> getAspspsPage(nextId))
                .doOnNext(saltedgeResponse -> {
                    if (saltedgeResponse.getMeta() != null && !"0".equals(saltedgeResponse.getMeta().getNextId())) {
                        nextId.set(saltedgeResponse.getMeta().getNextId());
                    } else {
                        nextId.set(null);
                    }
                })
                .repeat(() -> nextId.get() != null);
    }

    private Mono<SaltEdgeListResponse<SaltedgeProvider>> getAspspsPage(AtomicReference<String> nextId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(SALTEDGE_PROVIDER_PATH)
                        .queryParam("from_id", nextId.get())
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SaltEdgeListResponse<SaltedgeProvider>>() {
                });
    }

    @Override
    public Flux<MerchantInfo> getMerchantsInfo(MerchantsInfoRequest request) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path(SALTEDGE_MERCHANT_PATH)
                        .build())
                .body(fromValue(request))
                .retrieve().bodyToMono(SaltedgeMerchantResponse.class)
                .flatMapMany(ResponseHelper::getFluxFromData);
    }

}
