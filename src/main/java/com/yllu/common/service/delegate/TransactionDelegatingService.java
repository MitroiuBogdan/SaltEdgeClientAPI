package com.yllu.common.service.delegate;

import com.yllu.common.domain.Vendor;
import com.yllu.common.domain.entity.Transaction;
import com.yllu.common.service.TransactionVendorService;
import com.yllu.common.service.VendorServiceSelector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@Service
public class TransactionDelegatingService {
    List<TransactionVendorService> transactionVendorServices;

    public Flux<Transaction> getTransactions(Vendor vendor, String providerGrantId, String providerAccountId) {
        return VendorServiceSelector.selectVendorService(transactionVendorServices, vendor)
                .getTransactions(providerGrantId, providerAccountId);
    }

    public Mono<Transaction> getTransaction(Vendor vendor, String accountId) {
        return VendorServiceSelector.selectVendorService(transactionVendorServices, vendor)
                .getTransaction(accountId);
    }

}
