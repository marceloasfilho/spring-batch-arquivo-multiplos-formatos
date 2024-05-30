package com.github.marceloasfilho.springbatcharquivomultiplosformatos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosJobConfig {

    @Bean
    public Job leituraArquivoMultiplosFormatosJob(Step leituraArquivoMultiplosFormatosStep, JobRepository jobRepository) {
        return new JobBuilder("leituraArquivoMultiplosFormatosJob", jobRepository)
                .start(leituraArquivoMultiplosFormatosStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
