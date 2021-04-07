package com.algaworks.lojaveiculos.main;

import com.algaworks.lojaveiculos.dominio.Veiculo;
import com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ListandoVeiculos {

    public static void main(String[] args){

        EntityManager manager = JpaUtil.getEntityManager();

        List<Veiculo> veiculosList = manager.createQuery ("select v from Veiculo v", Veiculo.class).getResultList();

        veiculosList.forEach((v) -> System.out.println(v.getCodigo() + " - "
                                    + v.getFabricante() + "  "
                                    + v.getModelo() + ", ano "
                                    + v.getAnoFabricacao() + " / "
                                    + v.getAnoModelo() + " por "
                                    + " R$ " + v.getValor() + " Owner: "
                                    + v.getProprietario().getNome()));

        List<Veiculo> filtrado = veiculosList.stream()
                                    .filter(v -> v.getValor().compareTo(BigDecimal.valueOf(37000L)) <= 0)
                                    .collect(Collectors.toList());

        System.out.println("Valores filtrados: ");
        filtrado.forEach((v) -> System.out.println(v.getCodigo() + " - "
                + v.getFabricante() + "  "
                + v.getModelo() + ", ano "
                + v.getAnoFabricacao() + " / "
                + v.getAnoModelo() + " por "
                + " R$ " + v.getValor() + " Owner: "
                + v.getProprietario().getNome()));

        manager.close();
        JpaUtil.close();

    }

}
