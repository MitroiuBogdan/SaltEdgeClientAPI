package com.yllu.service.user;

import com.yllu.vendor.saltedge.rest.client.response.ais.SaltEdgeCustomer;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRemoteService {

    Mono<SaltEdgeCustomer> createCustomer(String identifier);

    Mono<ResponseEntity<Void>> deleteCustomer(String customerId);

    Flux<SaltEdgeCustomer> getCustomers();

    Mono<SaltEdgeCustomer> getCustomerById(String customerId);
}
