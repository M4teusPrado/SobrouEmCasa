package com.pa.sobrouemcasa.dto;

import com.pa.sobrouemcasa.model.Endereco;
import lombok.Data;

@Data
public class DoadorDTO {

    private String nome;
    private String descricao;
    private Endereco endereco;
    private String senha;

}
