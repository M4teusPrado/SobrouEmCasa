package com.server.sobrouemcasa.model.enums;

public enum Genero {

    MASCULINO(1L, "M"),
    FEMININO(2L, "F"),
    OUTROS(3L, "");

    private Long valor;
    private String descricao;

    Genero(long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long valor() { return valor;}
    public String descricao() { return descricao;}

    public static Genero valueOf(Long valor) {
        for (Genero v: Genero.values())
            if(v.valor().equals(valor))
                return v;
        return null;
    }
}
