package sco.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioWebTest {
	
	UsuarioWeb usuarioWeb = new UsuarioWeb();
	final Usuario usuario = new Usuario("felipe","123456","Felipe Ribeiro");
	
	@Test
	public void verificaSeLoginExecutaCorretamente(){
		//Executa o login
		usuarioWeb.login(usuario);
		
		//Verifica se logou com o usuário certo
		assertEquals(usuario.getLogin(),usuarioWeb.getUsuarioLogado());
		assertEquals(usuario.getNome(),usuarioWeb.getNome());
		assertTrue(usuarioWeb.isLogado());
		
	}
	/**
	 * Verifica que o UsuarioWeb inicia indicando que não tem usuário logado
	 */
	@Test
	public void verificaStatusInicialDoUsuarioWeb(){
		assertFalse(usuarioWeb.isLogado());
	}
	
	
	@Test
	public void verificaLogout(){
		
		usuarioWeb.login(usuario);
		usuarioWeb.logout();
		
		assertFalse(usuarioWeb.isLogado());
	}

}
