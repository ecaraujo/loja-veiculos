package com.algaworks.lojaveiculos.main;

import com.algaworks.lojaveiculos.dominio.Proprietario;
import com.algaworks.lojaveiculos.dominio.Veiculo;
import com.algaworks.lojaveiculos.enums.TipoCombustivel;
import com.algaworks.lojaveiculos.pk.VeiculoId;
import com.algaworks.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.util.Date;

public class PersistindoVeiculo {

    public static void main(String[] args){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("João das Couves");
        proprietario.setTelefone("(34) 1234-5678");
        proprietario.setEmail("edson.caraujo@hotmail.com");
        manager.persist(proprietario);

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(new VeiculoId("ABC-1234", "Uberlândia"));
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(new Date());
        veiculo.setProprietario(proprietario);
        manager.persist(veiculo);

        tx.commit();
        manager.close();
        JpaUtil.close();
    }

}
