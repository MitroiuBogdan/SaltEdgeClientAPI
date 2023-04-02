package com.yllu.vendor.saltedge.service;

import com.yllu.common.domain.entity.Transaction;
import com.yllu.common.domain.Vendor;
import com.yllu.common.service.TransactionVendorService;
import com.yllu.vendor.saltedge.rest.client.SaltEdgeClientImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.yllu.vendor.saltedge.mapper.SaltedgeTransactionMapper.SALTEDGE_TX_MAPPER;

@AllArgsConstructor
@Service
public class SaltedgeTransactionService implements TransactionVendorService {

    private final SaltEdgeClientImpl saltEdgeClient;

    @Override
    public Flux<Transaction> getTransactions(String connectionId, String accountId) {

        return saltEdgeClient.getTransactions(connectionId, accountId)
                .map(SALTEDGE_TX_MAPPER);
    }

    @Override
    public Mono<Transaction> getTransaction(String transactionId) {
        return Mono.empty();
    }

    @Override
    public boolean isForVendor(Vendor vendor) {
        return Vendor.SALTEDGE.equals(vendor);
    }
}
