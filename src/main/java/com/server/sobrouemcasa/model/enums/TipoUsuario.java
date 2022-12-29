package com.server.sobrouemcasa.model.enums;

public enum TipoUsuario {

    RESPONSAVEL(1L, "Responsavel"),
    DOADOR(2L, "Doador");

    private Long valor;
    private String descricao;

    TipoUsuario(long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long valor() { return valor;}
    public String descricao() { return descricao;}

    public static TipoUsuario valueOf(Long valor) {
        for (TipoUsuario v: TipoUsuario.values())
            if(v.valor().equals(valor))
                return v;
        return null;
    }
}
