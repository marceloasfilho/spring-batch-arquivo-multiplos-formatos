package com.github.marceloasfilho.springbatcharquivomultiplosformatos.step;

import com.github.marceloasfilho.springbatcharquivomultiplosformatos.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@SuppressWarnings({"rawtypes", "unchecked"})
@Configuration
public class LeituraMultiplosArquivosClienteTransacaoStepConfig {
    @Bean
    public Step leituraMultiplosArquivosClienteTransacaoStep(MultiResourceItemReader<Cliente> leituraMultiplosArquivosClienteTransacaoReader,
                                                                    ItemWriter leituraArquivoMultiplosFormatosWriter,
                                                                    JobRepository jobRepository,
                                                                    PlatformTransactionManager transactionManager) {
        return new StepBuilder("leituraMultiplosArquivosClienteTransacaoStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(leituraMultiplosArquivosClienteTransacaoReader)
                .writer(leituraArquivoMultiplosFormatosWriter)
                .build();
    }
}
