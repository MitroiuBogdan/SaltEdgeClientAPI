package com.yllu.common.service;

import com.yllu.common.domain.entity.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionVendorService extends VendorService {


    Flux<Transaction> getTransactions(String providerGrantId, String providerAccountId);

    Mono<Transaction> getTransaction(String transactionId);
}
