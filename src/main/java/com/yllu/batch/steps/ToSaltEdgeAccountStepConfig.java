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
public class ToSaltEdgeAccountStepConfig {

    StepBuilderFactory stepBuilderFactory;


    @JobScope
    @Bean(name = "toSaltEdgeAccountStep")
    public Step toSaltEdgeAccountStep(@Value("#{jobParameters['connectionId']}") String connectionId) {
        return stepBuilderFactory
                .get("toSaltEdgeAccountStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("toSaltEdgeAccountStep - Start fetching accounts for connectionId: {}", connectionId);
                    // TODO: GET ACCOUNTS FORM SALTEDGE
                            return null;
                        }
                ).build();
    }
}
