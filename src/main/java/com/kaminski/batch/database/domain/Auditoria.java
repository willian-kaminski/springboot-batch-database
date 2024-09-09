package com.kaminski.batch.database.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Auditoria {

    private Integer id;
    private String nome;
    private LocalDateTime dataHora;

}