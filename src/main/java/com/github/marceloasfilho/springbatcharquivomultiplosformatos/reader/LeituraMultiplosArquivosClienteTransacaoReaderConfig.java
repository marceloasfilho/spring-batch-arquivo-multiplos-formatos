package com.github.marceloasfilho.springbatcharquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@SuppressWarnings({"unchecked", "rawtypes"})
@Configuration
public class LeituraMultiplosArquivosClienteTransacaoReaderConfig {
    @StepScope
    @Bean
    public MultiResourceItemReader leituraMultiplosArquivosClienteTransacaoReader(
            @Value("#{jobParameters['arquivosClientes']}") Resource[] arquivosClientes,
            FlatFileItemReader leituraArquivoMultiplosFormatosReader) {
        return new MultiResourceItemReaderBuilder<>()
                .name("leituraMultiplosArquivosClienteTransacaoReader")
                .resources(arquivosClientes)
                .delegate(new LeituraArquivoClienteTransacaoReaderConfig(leituraArquivoMultiplosFormatosReader))
                .build();
    }
}
