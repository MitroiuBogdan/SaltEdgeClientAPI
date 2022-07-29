package com.ing.casyadapterpoc.controller;

import com.ing.casyadapterpoc.domain.Account;
import com.ing.casyadapterpoc.domain.Transaction;
import com.ing.casyadapterpoc.domain.Vendor;
import com.ing.casyadapterpoc.service.AccountDelegatingService;
import com.ing.casyadapterpoc.service.TransactionDelegatingService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ing.casyadapterpoc.logging.LoggingHelper.buildLogMessage;

@AllArgsConstructor
@RestController
@RequestMapping("accounts")
@Log
public class TransactionController {
    private final TransactionDelegatingService transactionDelegatingService;

    @GetMapping
    public Flux<Transaction> getAccounts(Vendor vendor) {
        log.info("Getting accounts:");

        return transactionDelegatingService.getTransactions(vendor)
                .doOnNext(tx -> log.info(buildLogMessage(tx)));

    }

    @GetMapping(path = "/{accountId}")
    public Mono<Transaction> getAccount(Vendor vendor, @PathVariable String accountId) {
        log.info("Getting account with id: "+ accountId);
        return transactionDelegatingService.getTransaction(vendor,accountId)
                .doOnNext(tx -> log.info(buildLogMessage(tx)));
    }

}
