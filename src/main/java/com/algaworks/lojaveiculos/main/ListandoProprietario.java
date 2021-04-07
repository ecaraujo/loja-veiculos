package com.algaworks.lojaveiculos.main;

import com.algaworks.lojaveiculos.dominio.Proprietario;
import com.algaworks.lojaveiculos.dominio.Veiculo;
import com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ListandoProprietario {

    public static void main(String[] args){

        EntityManager manager = JpaUtil.getEntityManager();

        List<Veiculo> veiculos = manager.createQuery("select v from Veiculo v", Veiculo.class).getResultList();

        veiculos.forEach(v -> System.out.println(v.getModelo() + " - " + v.getProprietario().getNome()));

        manager.close();
        JpaUtil.close();

    }

}
