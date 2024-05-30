package com.github.marceloasfilho.springbatcharquivomultiplosformatos.step;

import com.github.marceloasfilho.springbatcharquivomultiplosformatos.reader.LeituraArquivoClienteTransacaoReaderConfig;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@SuppressWarnings({"rawtypes", "unchecked"})
public class LeituraArquivoMultiplosFormatosClienteTransacaoStepConfig {
    @Bean
    public Step leituraArquivoMultiplosFormatosClienteTransacaoStep(FlatFileItemReader leituraArquivoMultiplosFormatosReader,
                                                                    ItemWriter leituraArquivoMultiplosFormatosWriter,
                                                                    JobRepository jobRepository,
                                                                    PlatformTransactionManager transactionManager) {
        return new StepBuilder("leituraArquivoMultiplosFormatosClienteTransacaoStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(new LeituraArquivoClienteTransacaoReaderConfig(leituraArquivoMultiplosFormatosReader))
                .writer(leituraArquivoMultiplosFormatosWriter)
                .build();
    }
}
