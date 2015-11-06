package sco.controller;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import sco.dao.ProdutoDao;
import sco.model.Carrinho;
import sco.model.Produto;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.HibernateMockValidator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
//import static org.mockito.Matchers.any;

public class ProdutosControllerTest {
	
	
	private MockResult result;
	private MockValidator validator;
	private ProdutosController produtosController;
	private ProdutoDao dao;
	private Carrinho	carrinho;
	
	
	@Before
	public void setUp(){
	      this.dao = mock(ProdutoDao.class);
	      result = spy(new MockResult());
	      validator = spy(new HibernateMockValidator());
	      this.carrinho = mock(Carrinho.class);
	      produtosController = new ProdutosController(dao, result, validator, carrinho);
	}
	
	@Test
	public void deveriaAdicionarUmProduto(){
		Produto produto = new Produto(1L,"Arroz","Camil",5.50);
		produtosController.adiciona(produto);
		verify(dao).salva(produto);
	}
	
	@Test(expected=ValidationException.class)
	public void verificaRedirecionamentoQuandoProdutoAdicionadoNaoEhValido(){
		Produto produto = new Produto();
		produtosController.adiciona(produto);
		verify(dao).salva(produto);		
	}
	
}
