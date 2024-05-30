package com.github.marceloasfilho.springbatcharquivomultiplosformatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@SuppressWarnings({"rawtypes", "unchecked"})
public class LeituraArquivoMultiplosFormatosStepConfig {
    @Bean
    public Step leituraArquivoMultiplosFormatosStep(ItemReader leituraArquivoMultiplosFormatosReader,
                                                    ItemWriter leituraArquivoMultiplosFormatosWriter,
                                                    JobRepository jobRepository,
                                                    PlatformTransactionManager transactionManager) {
        return new StepBuilder("leituraArquivoMultiplosFormatosStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(leituraArquivoMultiplosFormatosReader)
                .writer(leituraArquivoMultiplosFormatosWriter)
                .build();
    }
}
