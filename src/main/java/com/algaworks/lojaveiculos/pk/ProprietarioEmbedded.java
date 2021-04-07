package com.algaworks.lojaveiculos.pk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class ProprietarioEmbedded {

    @Column(name = "nome_proprietario", nullable = false)
    private String nome;

    @Column(name = "telefone_proprietario", nullable = false)
    private String telefone;

    @Column(name = "email_proprietario", nullable = false)
    private String email;

}
