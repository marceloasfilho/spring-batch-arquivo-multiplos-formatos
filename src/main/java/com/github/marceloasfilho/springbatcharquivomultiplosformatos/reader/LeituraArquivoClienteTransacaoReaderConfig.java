package com.github.marceloasfilho.springbatcharquivomultiplosformatos.reader;

import com.github.marceloasfilho.springbatcharquivomultiplosformatos.domain.Cliente;
import com.github.marceloasfilho.springbatcharquivomultiplosformatos.domain.ClienteTransacao;
import com.github.marceloasfilho.springbatcharquivomultiplosformatos.domain.Transacao;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

import java.util.ArrayList;

@RequiredArgsConstructor
public class LeituraArquivoClienteTransacaoReaderConfig implements ItemStreamReader<ClienteTransacao> {

    private final ItemStreamReader<Object> delegate;
    private Object clienteOuTransacaoAtual;

    @Override
    public ClienteTransacao read() throws Exception {

        if (this.clienteOuTransacaoAtual == null) {
            this.clienteOuTransacaoAtual = this.delegate.read();
        }

        Cliente cliente = (Cliente) this.clienteOuTransacaoAtual;
        this.clienteOuTransacaoAtual = null;
        ClienteTransacao clienteTransacao = null;

        if (cliente != null) {
            clienteTransacao = ClienteTransacao.builder()
                    .nome(cliente.getNome())
                    .sobrenome(cliente.getSobrenome())
                    .idade(Integer.valueOf(cliente.getIdade()))
                    .email(cliente.getEmail())
                    .transacoes(new ArrayList<>())
                    .build();

            while (peek() instanceof Transacao) {
                clienteTransacao.getTransacoes().add((Transacao) this.clienteOuTransacaoAtual);
            }
        }

        return clienteTransacao;
    }

    private Object peek() throws Exception {
        this.clienteOuTransacaoAtual = this.delegate.read();
        return this.clienteOuTransacaoAtual;
    }

    @Override
    public void open(@NonNull ExecutionContext executionContext) throws ItemStreamException {
        this.delegate.open(executionContext);
    }

    @Override
    public void update(@NonNull ExecutionContext executionContext) throws ItemStreamException {
        this.delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        this.delegate.close();
    }
}
