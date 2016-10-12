package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacoesConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 2);
		
		System.out.println("Titular conta: " + movimentacao.getConta().getTitular());
		
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println(conta.getMovimentacoes().size());
		
		Query query = em.createQuery("select c from Conta c join fetch c.movimentacoes");
		
		List<Conta> contas = query.getResultList();
		for (Conta c : contas) {
			System.out.println("Número de movimentações: " + c.getMovimentacoes().size());
		}
		
		em.close();

	}

}
