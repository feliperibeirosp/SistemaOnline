package sco.model;

public class Item {

	private Produto produto;

	private Integer quantidade;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		//if (produto != null)
			this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		if (quantidade < 0)
			quantidade = 0;
		this.quantidade = quantidade;
	}

}
