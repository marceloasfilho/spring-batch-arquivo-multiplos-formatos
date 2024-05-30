package com.github.marceloasfilho.springbatcharquivomultiplosformatos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteTransacao {
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;
    private List<Transacao> transacoes;
}
