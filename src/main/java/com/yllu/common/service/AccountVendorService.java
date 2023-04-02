package com.yllu.common.service;

import com.yllu.common.domain.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountVendorService extends VendorService {

    Flux<Account> getAccounts(String providerGrantId);

    Mono<Account> getAccount(String accountId);
}
