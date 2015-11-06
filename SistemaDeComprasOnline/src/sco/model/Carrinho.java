package sco.model;

import java.util.ArrayList;
import java.util.List;


import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {
	
	private List<Item> itens = new ArrayList<Item>();
	
	private Double total = 0.0;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void adiciona(Item item) {
		if( item != null ){
			itens.add(item);
			total += item.getProduto().getPreco() * item.getQuantidade();
		}
	}
	
	public Integer getTotalDeItens(){
		return itens.size();
	}
	//alterada
	public void remove(int indiceItem) {
		if(indiceItem < itens.size() && indiceItem >= 0){
			Item removido = itens.remove(indiceItem);
			total -= removido.getProduto().getPreco() * removido.getQuantidade();
		}
	}
	//verificar
	public boolean getItem(Produto produto){
		if(produto != null)
			for(Item item : itens){
				if(item.getProduto().getId() == produto.getId()) return true;
			}
		return false;
	}
	
	

}
