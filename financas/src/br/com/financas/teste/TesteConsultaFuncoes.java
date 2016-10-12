package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		/*Query query = em.createQuery("select sum(m.valor) from Movimentacao m "
				+ "where m.conta = :pConta and m.tipo = :pTipoMovimentacao");*/
		TypedQuery<BigDecimal> query = em.createQuery("select sum(m.valor) from Movimentacao m "
				+ "where m.conta = :pConta and m.tipo = :pTipoMovimentacao", BigDecimal.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipoMovimentacao", TipoMovimentacao.ENTRADA);
		
		//BigDecimal soma = (BigDecimal) query.getSingleResult();
		BigDecimal soma = query.getSingleResult();
		
		System.out.println("Soma é: " + soma);
		
		//o retorno da função avg de média é double
		TypedQuery<Double> tq = em.createQuery("select avg(m.valor) from Movimentacao m "
				+ "where m.conta = :pConta", Double.class);
		
		tq.setParameter("pConta", conta);
		
		Double media = tq.getSingleResult();
		
		System.out.println("Média é: " + media);
		
		em.close();

	}

}
