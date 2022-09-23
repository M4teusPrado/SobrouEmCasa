package com.server.sobrouemcasa.model.enums;

public enum Categoria {


    ELETRODOMESTISCO("Eletrodomestico"),
    MOVEIS("Moveis"),
    LIVROS_E_REVISTA("Livros e revistas"),
    BRIQUEDOS("Brinquedos"),
    ROUPAS("Roupas"),
    ALIMENTOS("Alimentos"),
    HIGIENE_PESSOAL("Higiene Pessoal"),
    PRODUTOS_DE_LIMPEZA("Produtos de Limpeza"),
    CALCADOS("Calçados"),
    TECNOLOGIA("Tecnologia"),
    OUTROS("Outros");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
