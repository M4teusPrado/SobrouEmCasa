package com.server.sobrouemcasa.model.enums;

public enum Categoria {


    ELETRODOMESTISCO(0, "Eletrodomestico"),
    MOVEIS(1,"Moveis"),
    LIVROS_E_REVISTA(2,"Livros e revistas"),
    BRIQUEDOS(3,"Brinquedos"),
    ROUPAS(4,"Roupas"),
    ALIMENTOS(5,"Alimentos"),
    HIGIENE_PESSOAL(6,"Higiene Pessoal"),
    PRODUTOS_DE_LIMPEZA(7,"Produtos de Limpeza"),
    CALCADOS(8,"Calçados"),
    TECNOLOGIA(9,"Tecnologia"),
    OUTROS(10, "Outros");

    private Long valor;
    private String descricao;

    Categoria(long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long valor() { return valor;}
    public String descricao() { return descricao;}

    public static Categoria valueOf(Long valor) {
        for (Categoria v: Categoria.values())
            if(v.valor().equals(valor))
                return v;
        return null;
    }
}
