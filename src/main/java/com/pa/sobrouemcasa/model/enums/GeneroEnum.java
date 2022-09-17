package com.pa.sobrouemcasa.model.enums;

public enum GeneroEnum {

    MASCULINO(1L, "M"),
    FEMININO(2L, "F"),
    OUTROS(3L, "");

    private Long valor;
    private String descricao;

    GeneroEnum(long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long valor() { return valor;}
    public String descricao() { return descricao;}

    public static GeneroEnum valueOf(Long valor) {
        for (GeneroEnum v: GeneroEnum.values())
            if(v.valor().equals(valor))
                return v;
        return null;
    }
}
