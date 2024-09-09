package com.kaminski.batch.database.configuration.batch;

import com.kaminski.batch.database.domain.Auditoria;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepAuditoriaConfiguration {

    @Bean
    public Step processarAuditoria(JobRepository jobRepository, PlatformTransactionManager transactionManager,
            ItemReader<Auditoria> itemReader, ItemWriter<Auditoria> itemWriter){

        return new StepBuilder("stepProcessarAuditoria", jobRepository)
                .<Auditoria, Auditoria>chunk(1, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .allowStartIfComplete(true)
                .build();
    }

}