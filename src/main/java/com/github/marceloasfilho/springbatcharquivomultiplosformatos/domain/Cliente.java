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
public class Cliente {
    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
    private List<Transacao> transacoes;
}
