package com.yllu.vendor.saltedge.batch.steps;

import com.yllu.common.domain.Vendor;
import com.yllu.common.domain.entity.Transaction;
import com.yllu.common.service.delegate.TransactionDelegatingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@AllArgsConstructor
public class ToSaltEdgeTransactionStepConfig {

    StepBuilderFactory stepBuilderFactory;
    TransactionDelegatingService transactionDelegatingService;

    @JobScope
    @Bean(name = "toSaltEdgeTransactionStep")
    public Step toSaltEdgeTransactionStep(@Value("#{jobParameters['connectionId']}") String connectionId) {
        return stepBuilderFactory
                .get("toSaltEdgeTransactionStep")
                .tasklet((contribution, chunkContext) -> {
                            log.info("toSaltEdgeTransactionStep - Start fetching transaction for connectionId: {}", connectionId);
                            List<Transaction> transactionList = transactionDelegatingService.getTransactions(Vendor.SALTEDGE, connectionId, null)
                                    .collectList()
                                    .block();
                            transactionList.forEach(transaction -> log.info("Transaction: [{}]", transaction.toString()));
                            return null;
                        }
                ).build();
    }
}
