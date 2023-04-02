package com.yllu.vendor.saltedge.service;

import com.yllu.common.domain.entity.Account;
import com.yllu.common.domain.Vendor;
import com.yllu.common.service.AccountVendorService;
import com.yllu.vendor.saltedge.rest.client.SaltEdgeClientImpl;
import com.yllu.vendor.saltedge.mapper.SaltedgeAccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class SaltedgeAccountService implements AccountVendorService {
    private final SaltEdgeClientImpl saltEdgeClient;

    private static final Vendor VENDOR = Vendor.SALTEDGE;

    @Override
    public boolean isForVendor(Vendor vendor) {
        return VENDOR.equals(vendor);
    }

    public Flux<Account> getAccounts(String connectionId) {
        return saltEdgeClient.getAccounts(connectionId)
                .map(SaltedgeAccountMapper.SALTEDGE_ACCOUNT_MAPPER);
    }

    @Override
    public Mono<Account> getAccount(String accountId) {
        return Mono.empty();
    }


}