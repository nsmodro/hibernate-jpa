package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 10);

        // commit antes da altera��o
        manager.getTransaction().commit();

        // Altera��o do titular da conta
        conta.setTitular("Jo�o Jos� Santos");
        
        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();

        manager.close();

	}

}
