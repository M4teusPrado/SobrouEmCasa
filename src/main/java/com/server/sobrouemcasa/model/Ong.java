package com.server.sobrouemcasa.model;

import com.server.sobrouemcasa.model.enums.GeneroEnum;
import com.server.sobrouemcasa.model.enums.TipoUsuarioEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
public class Ong {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;
    private String finalidadeInstitucional;
    private Date dataConstitucional;
    private String email;
    private Usuario usuario;

    public Ong() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFinalidadeInstitucional() {
        return finalidadeInstitucional;
    }

    public void setFinalidadeInstitucional(String finalidadeInstitucional) {
        this.finalidadeInstitucional = finalidadeInstitucional;
    }

    public Date getDataConstitucional() {
        return dataConstitucional;
    }

    public void setDataConstitucional(Date dataConstitucional) {
        this.dataConstitucional = dataConstitucional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
