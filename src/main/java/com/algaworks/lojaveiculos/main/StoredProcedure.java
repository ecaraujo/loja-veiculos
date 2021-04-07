package com.algaworks.lojaveiculos.main;

import com.algaworks.lojaveiculos.dominio.Car;
import com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class StoredProcedure {

    public static void main(String[] args){
        findCarsByYearWithNamedStored();
    }

    public static void findCarsByYearWithNamedStored() {

        EntityManager manager = JpaUtil.getEntityManager();

        StoredProcedureQuery findByYearProcedure = manager.createNamedStoredProcedureQuery("findByYearProcedure");

        StoredProcedureQuery storedProcedure = findByYearProcedure.setParameter("p_year", 2020);

        List<Car> cars = storedProcedure.getResultList();

        System.out.println("Carros: " + cars);

    }

}
