package com.algaworks.lojaveiculos.dominio;

import com.algaworks.lojaveiculos.enums.TipoCombustivel;
import com.algaworks.lojaveiculos.pk.VeiculoId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo implements Serializable {

    @EmbeddedId
    private VeiculoId codigo;

    @Column(name = "tipo_combustivel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "fabricante", length = 60, nullable = false)
    private String fabricante;

    @Column(name = "modelo", length = 60, nullable = false)
    private String modelo;

    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Transient
    private String descricaoCompleta;

    @ManyToOne
    @JoinColumn(name="cod_proprietario", nullable=false)
    private Proprietario proprietario;

    public Veiculo(){
    }

    public Veiculo(String placa, String cidade, TipoCombustivel tipoCombustivel, String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo, BigDecimal valor, Date dataCadastro, String descricaoCompleta, Proprietario proprietario) {
        super();
        this.codigo.setPlaca(placa);
        this.codigo.setCidade(cidade);
        this.tipoCombustivel = tipoCombustivel;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.descricaoCompleta = descricaoCompleta;
        this.proprietario = proprietario;
    }

    public VeiculoId getCodigo() {
        return codigo;
    }

    public void setCodigo(VeiculoId codigo) {
        this.codigo = codigo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(codigo, veiculo.codigo) && Objects.equals(fabricante, veiculo.fabricante) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(anoFabricacao, veiculo.anoFabricacao) && Objects.equals(anoModelo, veiculo.anoModelo) && Objects.equals(valor, veiculo.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fabricante, modelo, anoFabricacao, anoModelo, valor);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa=" + codigo.getPlaca() +
                "cidade=" + codigo.getCidade() +
                ", tipoCombustivel=" + tipoCombustivel +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                ", valor=" + valor +
                ", dataCadastro=" + dataCadastro +
                ", descricaoCompleta='" + descricaoCompleta + '\'' +
                ", proprietario=" + proprietario +
                '}';
    }
}
