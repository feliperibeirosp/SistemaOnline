package sco.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
	
	Item item = new Item();
	@Test
	public void  verificaSeGettersESettersSeComportamCorretamente(){
		//Definição de valores para o teste
		final Integer quantidade = 15;
		final Produto produto = new Produto();
		
		
		//Execução das operações
		item.setProduto(produto);
		item.setQuantidade(quantidade);
		
		//Verificações das operações
		assertEquals( quantidade, item.getQuantidade() , 0.0 );
		assertEquals( produto , item.getProduto());
	}
	@Test
	public void verificarSeQuantidadeAtribuiZeroCasoRecebaUmValorNegativo(){
		final Integer quantidade = -1;
		
		item.setQuantidade(quantidade);
		
		assertEquals(0 , item.getQuantidade() , 0.0 );
		
	}
	//verificar o que fazer quando tiver um produto nulo
	@Test
	public void verificarSeTrataQuandoProdutoIgualANull(){
		
		item.setProduto(null);
		
		assertEquals(null , item.getProduto());
	}

}
