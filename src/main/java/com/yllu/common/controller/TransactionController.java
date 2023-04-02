package com.yllu.common.controller;

import com.yllu.common.domain.Vendor;
import com.yllu.common.domain.entity.Transaction;
import com.yllu.common.service.delegate.ExcelWriterDelegatingService;
import com.yllu.common.service.delegate.TransactionDelegatingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static com.yllu.common.logging.LoggingHelper.buildLogMessage;

@AllArgsConstructor
@RestController
@RequestMapping()
@Slf4j
public class TransactionController {
    private final TransactionDelegatingService transactionDelegatingService;
    private final ExcelWriterDelegatingService excelWriter;

    @GetMapping({"{vendor}/{providerGrantId}/transactions"})
    public Flux<Transaction> getTransactions(@PathVariable Vendor vendor,
                                             @PathVariable String providerGrantId,
                                             @RequestParam(required = false) String providerAccountId) {
        log.info("Getting transactions for vendor: {}, providerGrantId: {}, providerAccountId: {}", vendor.name(), providerGrantId, providerAccountId);

        return transactionDelegatingService.getTransactions(vendor, providerGrantId, providerAccountId)
                .doOnNext(trx -> log.info(buildLogMessage(trx)))
                .doOnNext(trx -> excelWriter.writeTransactionForVendor(trx, vendor));

    }

}
