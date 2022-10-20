package com.server.sobrouemcasa.dto;

import java.util.Date;

import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.model.enums.Categoria;

import lombok.Data;

@Data
public class RetFiltroDoacaoDTO {

    private String nome;
    private String descricao;
    private Categoria categoria;
    private Date data;
    private Double distancia;
    
    public RetFiltroDoacaoDTO(Doacao doacao, Double distanciaPontos) {
        this.nome = doacao.getNome();
        this.descricao = doacao.getDescricao();
        this.categoria = doacao.getCategoria();
        this.data = doacao.getDataDeCriacao();
        this.distancia = distanciaPontos;
    } 

    
}