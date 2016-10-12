package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		conta.setTitular("João Santos");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("123");
		conta.setNumero("78945");
		
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		EntityManager manager = entityManagerFactory.createEntityManager();*/
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		
		manager.getTransaction().commit();
		
		manager.close();
	}

}
