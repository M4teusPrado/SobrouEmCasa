package com.server.sobrouemcasa.dto;

import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoadorDTO {

    private String nome;
    private String descricao;
    private Endereco endereco;
    private String senha;
    private String cpf;

    public DoadorDTO(Doador doador){
        this.nome = doador.getNome();
        this.descricao = doador.getDescricao();
        this.endereco = doador.getEndereco();
        this.cpf = doador.getCpfFormatado();
    }
}