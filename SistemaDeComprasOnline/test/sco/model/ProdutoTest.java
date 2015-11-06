package sco.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class ProdutoTest {
	
	Produto produto = new Produto();
	@Test
	public void verificaSeGettersESettersSeComportamCorretamente(){
		
		final Long id = (long) 1;
		final String nome = "leite";
		final String descricao = "desnatado";
		final Double preco = 5.50;
		
		produto.setId(id);
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(preco);
		
		assertEquals(id,produto.getId(),0.0);
		assertEquals(nome,produto.getNome());
		assertEquals(descricao,produto.getDescricao());
		assertEquals(preco,produto.getPreco(),0.0);
		
	}
	@Test
	public void verificaSeTrataPrecoMenorQueZero(){
		
		produto.setPreco(-1.0);
		
		assertEquals(0.0, produto.getPreco(),0.0);
	}
	@Test
	public void verificaSeTrataIDMenorQueZero(){
		
		final Long id = (long) -1;
		
		produto.setId(id);
		
		assertEquals(0, produto.getId(),0.0);
	}
}
