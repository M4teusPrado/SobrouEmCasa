package com.pa.sobrouemcasa.model.enums;

public enum TipoUsuarioEnum {

    RESPONSAVEL(1L, "Responsavel"),
    DOADOR(2L, "Doador");

    private Long valor;
    private String descricao;

    TipoUsuarioEnum(long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long valor() { return valor;}
    public String descricao() { return descricao;}

    public static TipoUsuarioEnum valueOf(Long valor) {
        for (TipoUsuarioEnum v: TipoUsuarioEnum.values())
            if(v.valor().equals(valor))
                return v;
        return null;
    }
}
