package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		conta.setTitular("João Santos");
		conta.setBanco("001 - BANCO DO BRASIL");
		conta.setAgencia("6543");
		conta.setNumero("16987-8");
		
		Conta c1 = new Conta();
		c1.setTitular("Alexandre Duarte");
		c1.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		c1.setAgencia("1745");
		c1.setNumero("86759-1");
		
		Conta c2 = new Conta();
		c2.setTitular("Leandra Marques");
		c2.setBanco("033 - BANCO SANTANDER ");
		c2.setAgencia("4606");
		c2.setNumero("46346-3");
		
		Conta c3 = new Conta();
		c3.setTitular("Antonio Duraes");
		c3.setBanco("341 - BANCO ITAU UNIBANCO");
		c3.setAgencia("9876");
		c3.setNumero("12345-6");
		
		Conta c4 = new Conta();
		c4.setTitular("Maria dos Santos");
		c4.setBanco("237 - BANCO BRADESCO ");
		c4.setAgencia("1234");
		c4.setNumero("98654-3");
		
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		EntityManager manager = entityManagerFactory.createEntityManager();*/
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		
		//em.persist(conta);
		/*Conta conta = em.find(Conta.class, 10); //classe do objeto e chave primária
		System.out.println(conta.getTitular());
		conta.setTitular("João Santos Silva");*/
		
		em.getTransaction().commit();
		//System.out.println(conta.getTitular());
		
		em.close();
	}

}
