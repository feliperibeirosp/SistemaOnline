package sco.teste;


import sco.dao.ProdutoDao;
import sco.model.Produto;


 public class AdicaoDeProduto {
	 public static void main(String[] args) {
		
		 Produto produto = criaProduto();
		
		 new ProdutoDao(null).salva(produto);
	 }

	private static Produto criaProduto() {
		
		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}
 }
