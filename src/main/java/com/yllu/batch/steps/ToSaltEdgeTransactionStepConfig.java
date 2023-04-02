package com.yllu.batch.steps;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AllArgsConstructor
public class ToSaltEdgeTransactionStepConfig {

    StepBuilderFactory stepBuilderFactory;

    @JobScope
    @Bean(name = "toSaltEdgeTransactionStep")
    public Step toSaltEdgeTransactionStep(@Value("#{jobParameters['connectionId']}") String connectionId) {
        return stepBuilderFactory
                .get("toSaltEdgeTransactionStep")
                .tasklet((contribution, chunkContext) -> {
                            log.info("toSaltEdgeTransactionStep - Start fetching transaction for connectionId: {}", connectionId);

                            //TODO: GET TRANSACTIONS FROM SALTEDGE
                            return null;
                        }
                ).build();
    }
}
