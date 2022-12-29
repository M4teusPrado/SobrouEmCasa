package com.server.sobrouemcasa.model;

import com.server.sobrouemcasa.model.enums.Genero;
import com.server.sobrouemcasa.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@Inheritance( strategy = InheritanceType.JOINED )
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não deve estar em branco.")
    @Size(min = 3, max = 40, message = "Nome deve conter no minimo 4 e no maximo 40 caracteres")
    private String nome;
    private String senha;
    private TipoUsuario tipoUsuario;
    private Long cpf;

    @NotBlank(message = "E-mail não deve estar em branco.")
    @Email(message = "Endereço de e-mail inválido.")
    private String email;
    private Genero genero;
    private Date dataNascimento;
    private String telefone;
    private String celular;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    public Usuario(
            Long id,
            String nome,
            String senha,
            TipoUsuario tipoUsuario,
            Long cpf,
            String email,
            Genero genero,
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

    public String getCpfFormatado(){
        String cpf = String.valueOf(this.cpf);
        return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
    }


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
