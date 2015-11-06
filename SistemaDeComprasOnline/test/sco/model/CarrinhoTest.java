package sco.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho = new Carrinho();
	private Item item = new Item();

	
	@Test
	public void  verificaSeGettersESettersSeComportamCorretamente(){
		//Definição de valores para o teste
		final double totalEsperado = 999.00;
		final List<Item> itens = Arrays.asList(new Item(),new Item());
		
		//Execução das operações
		carrinho.setTotal(totalEsperado);
		carrinho.setItens(itens);
		
		//Verificações das operações
		assertEquals( totalEsperado , carrinho.getTotal() , 0.0 );
		assertEquals( itens , carrinho.getItens() );
		assertEquals( itens.size() , carrinho.getTotalDeItens() , 0.0 );
	}
	
	@Test
	public void verificaSeConsegueAdicionarItens(){
		//Defini os valores para o teste
		
		item.setProduto(new Produto());
		item.getProduto().setPreco(5.00);
		item.setQuantidade(10);

		carrinho.adiciona(item);
		
		assertEquals( 1, carrinho.getItens().size() );
		assertEquals( item , carrinho.getItens().get(0) );
	}
	
	@Test
	public void verificaSeTrataQuandoItemNulo(){

		carrinho.adiciona(null);
		
		assertEquals( 0 , carrinho.getTotalDeItens() , 0.0 );
	}
	@Test
	public void verificaSeTrataQuandoIndiceNegativo(){
		

		carrinho.remove(-1);

		assertEquals( 0 , carrinho.getTotalDeItens() , 0.0 );
	}
	@Test
	public void verificaSeTrataQuandoGetItemRecebeProdutoNull(){

		item.setProduto(new Produto());
		item.getProduto().setPreco(5.00);
		item.setQuantidade(10);
		
		carrinho.adiciona(item);
		
		assertEquals( false , carrinho.getItem(null));
	}
	@Test
	public void verificaSeTrataQuandoGetItemRecebeProdutoIgual(){
		
		Produto produto = new Produto();
		item.setProduto(produto);
		item.getProduto().setId(1L);
		item.getProduto().setPreco(5.00);
		item.setQuantidade(10);
		
		carrinho.adiciona(item);
		
		assertEquals( true , carrinho.getItem(produto));
	}
	@Test
	public void verificaSeTrataQuandoGetItemRecebeProdutoDiferente(){
		
		Produto produto = new Produto();
		item.setProduto(produto);
		item.getProduto().setId(2L);
		item.getProduto().setPreco(5.00);
		item.setQuantidade(10);
		
		
		carrinho.adiciona(item);
		
		assertEquals( false , carrinho.getItem(new Produto()));
	}
}
