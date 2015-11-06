package sco.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import sco.dao.ProdutoDao;
import sco.model.Carrinho;
import sco.model.Produto;
import sco.notacao.Restrito;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import static br.com.caelum.vraptor.view.Results.*;

@Resource
public class ProdutosController {
	
	private ProdutoDao dao;
	private final Result result;
	private final Validator validator;
	private final Carrinho	carrinho;
	
	public ProdutosController(ProdutoDao dao, Result result, Validator validator, Carrinho carrinho){
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.carrinho = carrinho;
	}
	@Get @Path("/produtos")
	public List<Produto> lista(){
		
		return dao.listaTudo();
	}
	@Restrito @Post @Path("/produtos")
	public void adiciona(final Produto produto){
		
		validator.validate(produto);
		validator.onErrorUsePageOf(ProdutosController.class).formulario();
		dao.salva(produto);
		result.redirectTo(this).lista();
	}
	@Restrito @Get @Path("/produtos/novo")
	public void formulario(){
		
	}
	@Restrito @Get @Path("/produtos/{id}")
	public Produto edita(Long id){

		return dao.carrega(id);
	}
	@Restrito @Put @Path("/produtos/{produto.id}")
	public void altera(Produto produto){
		
			validator.validate(produto);
			validator.onErrorUsePageOf(ProdutosController.class).edita(produto.getId());
			dao.atualiza(produto);
		
			result.redirectTo(this).lista();
		
	}
	//verifica
	@Restrito @Delete @Path("/produtos/{id}")
	public void remove(Long id){
		
		Produto produto = dao.carrega(id);
		if(!carrinho.getItem(produto)){
			dao.remove(produto);
			result.redirectTo(this).lista();
		}else{
			validator.add(new ValidationMessage(
					"Produto se encontra no carrinho de compra, impossivel excluir ele!",
					"produto.nome"));
			validator.onErrorUsePageOf(CarrinhoController.class).visualiza();
			
		}
		
		result.redirectTo(this).lista();
	}

	public List<Produto> busca(String nome){
		result.include("nome",nome);
		return dao.busca(nome);
	}
	@Get @Path("/produtos/busca.json")
	public void buscaJson(String q){
		result.use(json()).withoutRoot()
		.from(dao.busca(q))
		.exclude("id","descricao")
		.serialize();
	}
}
