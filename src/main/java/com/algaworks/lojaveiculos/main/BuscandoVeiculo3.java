package com.algaworks.lojaveiculos.main;

import com.algaworks.lojaveiculos.dominio.Veiculo;
import com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class BuscandoVeiculo3 {

    public static void main(String[] args){

        EntityManager manager = JpaUtil.getEntityManager();

        Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
        System.out.println("Buscou veículo. Será que já executou o SELECT?");

        System.out.println("Veículo: " + veiculo.getModelo());

    }

}
