package com.server.sobrouemcasa.dto;

import java.util.Date;

import com.server.sobrouemcasa.model.enums.Categoria;

import lombok.Data;

@Data
public class RetFiltroDoacaoDTO {

    private String nome;
    private String descricao;
    private Categoria categoria;
    private Date data;
    private String distancia; 

    
}