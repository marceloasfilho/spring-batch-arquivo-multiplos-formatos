package com.github.marceloasfilho.springbatcharquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@SuppressWarnings({"rawtypes", "unchecked"})
@Configuration
public class LeituraArquivoMultiplosFormatosReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader leituraArquivoMultiplosFormatosReader(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes,
                                                                    LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder()
                .name("leituraArquivoMultiplosFormatosReader")
                .resource(arquivoClientes)
                .lineMapper(lineMapper)
                .build();
    }
}
