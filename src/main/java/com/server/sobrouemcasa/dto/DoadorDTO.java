package com.server.sobrouemcasa.dto;

import com.server.sobrouemcasa.model.Endereco;
import lombok.Data;

@Data
public class DoadorDTO {

    private String nome;
    private String descricao;
    private Endereco endereco;
    private String senha;

}
