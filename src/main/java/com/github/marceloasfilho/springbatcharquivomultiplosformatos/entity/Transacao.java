package com.github.marceloasfilho.springbatcharquivomultiplosformatos.entity;

import lombok.Data;

@Data
public class Transacao {
    private String id;
    private String descricao;
    private Double valor;
}
