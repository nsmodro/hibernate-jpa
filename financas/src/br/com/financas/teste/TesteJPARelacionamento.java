package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		/*Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Pagto. Conta Luz");
		movimentacao.setTipo(TipoMovimentacao.SAÍDA);
		movimentacao.setValor(new BigDecimal("189.98"));
		
		Conta conta = new Conta();
		conta.setTitular("Maria Oliveira");
		conta.setBanco("Citi");
		conta.setAgencia("1414");
		conta.setNumero("7258369");
		
		movimentacao.setConta(conta);*/
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Movimentacao m = new Movimentacao();
		m.setData(Calendar.getInstance());
		m.setDescricao("Pagto. Conta Luz");
		m.setTipo(TipoMovimentacao.SAÍDA);
		m.setValor(new BigDecimal("189.98"));
		m.setConta(em.find(Conta.class, 1));
		
		Movimentacao m1 = new Movimentacao();
		m1.setData(Calendar.getInstance());
		m1.setDescricao("Salário");
		m1.setTipo(TipoMovimentacao.ENTRADA);
		m1.setValor(new BigDecimal("1864.23"));
		m1.setConta(em.find(Conta.class, 1));

		Movimentacao m2 = new Movimentacao();
		m2.setData(Calendar.getInstance());
		m2.setDescricao("Almoço");
		m2.setTipo(TipoMovimentacao.SAÍDA);
		m2.setValor(new BigDecimal("14.7"));
		m2.setConta(em.find(Conta.class, 3));
		
		Movimentacao m3 = new Movimentacao();
		m3.setData(Calendar.getInstance());
		m3.setDescricao("Pagto. Aluguel");
		m3.setTipo(TipoMovimentacao.SAÍDA);
		m3.setValor(new BigDecimal("500"));
		m3.setConta(em.find(Conta.class, 5));
		
		Movimentacao m4 = new Movimentacao();
		m4.setData(Calendar.getInstance());
		m4.setDescricao("Presente da vó");
		m4.setTipo(TipoMovimentacao.ENTRADA);
		m4.setValor(new BigDecimal("200"));
		m4.setConta(em.find(Conta.class, 2));
		
		Movimentacao m5 = new Movimentacao();
		m5.setData(Calendar.getInstance());
		m5.setDescricao("Compra de Patins");
		m5.setTipo(TipoMovimentacao.SAÍDA);
		m5.setValor(new BigDecimal("149.99"));
		m5.setConta(em.find(Conta.class, 2));
		
		Movimentacao m6 = new Movimentacao();
		m6.setData(Calendar.getInstance());
		m6.setDescricao("Jantar Romantico");
		m6.setTipo(TipoMovimentacao.SAÍDA);
		m6.setValor(new BigDecimal("298.78"));
		m6.setConta(em.find(Conta.class, 4));
		
		
		//em.persist(conta);//isso é necessário pois se persistir apenas a movimemtação a conta ainda estará Transiente
		//em.persist(movimentacao);
		
		em.persist(m);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		em.persist(m5);
		//em.persist(m6);
		
		
		em.getTransaction().commit();
		em.close();
	}

}
