package com.yllu.service.user.implementation;

import com.yllu.vendor.saltedge.rest.client.SaltEdgeClientImpl;
import com.yllu.vendor.saltedge.rest.client.request.CreateCustomerRequest;
import com.yllu.vendor.saltedge.rest.client.request.SaltEdgeRequest;
import com.yllu.vendor.saltedge.rest.client.response.SaltEdgeResponse;
import com.yllu.vendor.saltedge.rest.client.response.ais.SaltEdgeCustomer;
import com.yllu.service.user.CustomerRemoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CustomerRemoteServiceImpl implements CustomerRemoteService {

    private final SaltEdgeClientImpl saltEdgeClient;

    @Override
    public Mono<SaltEdgeCustomer> createCustomer(String identifier) {
        SaltEdgeRequest request = SaltEdgeRequest.builder()
                .data(CreateCustomerRequest.builder()
                        .identifier(identifier)
                        .build())
                .build();

        return saltEdgeClient.createCustomer(request)
                .map(SaltEdgeResponse::getData);
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCustomer(String customerId) {
        return saltEdgeClient.deleteCustomer(customerId);
    }

    @Override
    public Flux<SaltEdgeCustomer> getCustomers() {
        return saltEdgeClient.getAllCustomers();
    }

    @Override
    public Mono<SaltEdgeCustomer> getCustomerById(String customerId) {
        return saltEdgeClient.getCustomerById(customerId)
                .map(SaltEdgeResponse::getData);
    }
}
