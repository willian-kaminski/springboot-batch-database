package com.kaminski.batch.database.configuration.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobAuditoriaConfiguration {

    @Bean
    public Job jobAuditoria(JobRepository jobRepository, Step step){
        return new JobBuilder("jobAuditoria", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

}
