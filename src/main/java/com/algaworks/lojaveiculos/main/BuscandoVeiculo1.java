package com.algaworks.lojaveiculos.main;

import com.algaworks.lojaveiculos.dominio.Veiculo;
import com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class BuscandoVeiculo1 {

    public static void main(String[] args){

        EntityManager manager = JpaUtil.getEntityManager();

        Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo pela primeira vez...");

        Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo pela segunda vez...");
        System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));

    }

}
