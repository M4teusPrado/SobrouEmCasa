package com.server.sobrouemcasa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.sobrouemcasa.model.enums.Genero;
import com.server.sobrouemcasa.model.enums.TipoUsuario;
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

    @JsonIgnore
    @OneToMany(mappedBy = "doador")
    @Setter(AccessLevel.NONE)
    private List<Doacao> doacoes;

    public Doador(Long id, String nome, String senha, TipoUsuario tipoUsuario, Long cpf, String email, Genero genero, Date dataNascimento, String telefone, String celular, Endereco endereco, String descricao) {
        super(id, nome, senha, tipoUsuario, cpf, email, genero, dataNascimento, telefone, celular, endereco);
        this.descricao = descricao;
    }

    public Doador() {}

    public void addDoacao(Doacao doacao){
        this.doacoes.add(doacao);
    }
}