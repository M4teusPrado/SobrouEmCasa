package com.pa.sobrouemcasa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pa.sobrouemcasa.model.enums.GeneroEnum;
import com.pa.sobrouemcasa.model.enums.TipoUsuarioEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name="USER_ID")
public class Doador extends Usuario {

    private String descricao;
    private List<Doacao> doacoes;


    public Doador(Long id, String nome, String senha, TipoUsuarioEnum tipoUsuario, String cpf, String email, GeneroEnum genero, Date dataNascimento, String telefone, String celular, Endereco endereco, String descricao) {
        super(id, nome, senha, tipoUsuario, cpf, email, genero, dataNascimento, telefone, celular, endereco);
        this.descricao = descricao;
    }

    public Doador() {}

    public void addDoacao(Doacao doacao){
        this.doacoes.add(doacao);
    }
}
