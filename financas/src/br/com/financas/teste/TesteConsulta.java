package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TesteConsulta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
//		Query query = em.createQuery("select m from Movimentacao m where m.conta.id = " + conta.getId());
//		Query query = em.createQuery("select m from Movimentacao m where m.conta = ?1");
		Query query = em.createQuery("select m from Movimentacao m where m.conta = :pConta");
		
//		query.setParameter(1, conta);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("\nDescrição..: " + movimentacao.getDescricao());
			System.out.println("Valor......: R$" + movimentacao.getValor());
		}

	}

}
