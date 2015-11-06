package sco.model;


import javax.persistence.*;
import org.hibernate.validator.Length;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotNull;

@Entity
public class Produto {
	
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@Length(min=3)
	private String nome;
	
	@NotNull
	@Length(max=40)
	private String descricao;
	
	@NotNull
	@Min(0)
	private Double preco;
	
	public Produto(){
		
	}
	public Produto(Long id, String nome,String descricao,Double preco){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id < 0) id = 0L;
			this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		if(preco < 0.0) preco = 0.0;
			this.preco = preco;
	}
	
	

}
