package com.github.marceloasfilho.springbatcharquivomultiplosformatos.domain;

import lombok.Data;

@Data
public class Transacao {
    private String id;
    private String descricao;
    private Double valor;
}
