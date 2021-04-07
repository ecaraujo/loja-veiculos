package com.algaworks.lojaveiculos.dominio;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "proprietario")
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @OneToMany(mappedBy =  "proprietario")
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Column(name = "nome_proprietario", nullable = false)
    private String nome;

    @Column(name = "telefone_proprietario", nullable = false)
    private String telefone;

    @Column(name = "email_proprietario", nullable = false)
    private String email;

    public Proprietario(){
    }
    public Proprietario(Long codigo, List<Veiculo> veiculos, String nome, String telefone, String email) {
        super();
        this.codigo = codigo;
        this.veiculos = veiculos;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculos(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void remVeiculos(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietario that = (Proprietario) o;
        return Objects.equals(codigo, that.codigo) && Objects.equals(veiculos, that.veiculos) && Objects.equals(nome, that.nome) && Objects.equals(telefone, that.telefone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, veiculos, nome, telefone, email);
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
