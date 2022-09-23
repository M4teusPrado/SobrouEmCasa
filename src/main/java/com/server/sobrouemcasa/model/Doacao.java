package com.server.sobrouemcasa.model;

import com.server.sobrouemcasa.model.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Doacao {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Categoria categoria;
    private Date dataDeCriacao;

    @ManyToOne()
    @JoinColumn(name="DOADOR_USER_ID")
    private Doador doador;
}
