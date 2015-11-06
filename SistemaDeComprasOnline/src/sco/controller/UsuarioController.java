package sco.controller;

import java.util.List;

import sco.dao.UsuarioDao;
import sco.model.Produto;
import sco.model.Usuario;
import sco.model.UsuarioWeb;
import sco.notacao.Restrito;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class UsuarioController {
	
	private final UsuarioDao dao;
	private final Result result;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;
	
	
	public UsuarioController(UsuarioDao dao, Result result, Validator validator, UsuarioWeb usuarioWeb){
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}
	@Restrito @Get @Path("/usuario")
	public List<Usuario> lista(){
		return dao.listaTudo();
	}
	@Post @Path("/usuario")
	public void adiciona(Usuario usuario){
		if(dao.existeUsuario(usuario)){
			validator.add(new ValidationMessage("Login já existe", "usuario.login"));
			
		}
		validator.onErrorUsePageOf(UsuarioController.class).novo();
		dao.adiciona(usuario);
		
		result.redirectTo(ProdutosController.class).lista();
	}
	@Get @Path("/login")
	public void loginForm(){
		
	}
	@Get @Path("/usuario/novo")
	public void novo(){
		
	}
	@Restrito @Get @Path("/usuario/editar/{login}")
	public Usuario edita(String login){
		return dao.carrega(login);
	}
	@Restrito @Put @Path("/usuario/{usuario.login}")
	public void altera(Usuario usuario){
		
		validator.validate(usuario);
		validator.onErrorUsePageOf(UsuarioController.class).edita(usuario.getLogin());
		dao.atualiza(usuario);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	@Restrito @Delete @Path("/usuario/{login}")
	public void remove(String login) {
		Usuario usuario = dao.carrega(login);
		dao.remove(usuario);
		result.redirectTo(UsuarioController.class).lista();
	}
	@Post @Path("/login")
	public void login(Usuario usuario){
		Usuario carregado = dao.carrega(usuario);
		if(carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		validator.onErrorUsePageOf(UsuarioController.class).loginForm();
		
		usuarioWeb.login(carregado);
		
		result.redirectTo(ProdutosController.class).lista();
	}
	
	
	@Path("logout")
	public void logout(){
		usuarioWeb.logout();
		result.redirectTo(ProdutosController.class).lista();
	}
	

	
	
	
	
	
	
}
