package com.pa.sobrouemcasa.model;

import com.pa.sobrouemcasa.model.enums.GeneroEnum;
import com.pa.sobrouemcasa.model.enums.TipoUsuarioEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Inheritance( strategy = InheritanceType.JOINED )
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{nome.not.blank}")
    private String nome;
    private String senha;
    private TipoUsuarioEnum tipoUsuario;
    private String cpf;
    @NotBlank(message = "{email.not.blank}")
    private String email;
    private GeneroEnum genero;
    private Date dataNascimento;
    private String telefone;
    private String celular;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    public Usuario(
            Long id,
            String nome,
            String senha,
            TipoUsuarioEnum tipoUsuario,
            String cpf,
            String email,
            GeneroEnum genero,
            Date dataNascimento,
            String telefone,
            String celular,
            Endereco endereco
    ){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.email = email;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }


    public Usuario() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(senha, usuario.senha) && tipoUsuario == usuario.tipoUsuario && Objects.equals(cpf, usuario.cpf) && Objects.equals(email, usuario.email) && genero == usuario.genero && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(telefone, usuario.telefone) && Objects.equals(celular, usuario.celular) && Objects.equals(endereco, usuario.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, senha, tipoUsuario, cpf, email, genero, dataNascimento, telefone, celular, endereco);
    }
}
