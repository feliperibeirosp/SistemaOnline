package sco.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UsuarioTest {

	Usuario usuario = new Usuario();
	
	@Test
	public void verificaSeGettersESettersSeComportamCorretamente(){
		
		final String login = "login";
		final String nome = "nome";
		final String senha = "senha";
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		assertEquals(login,usuario.getLogin());
		assertEquals(nome, usuario.getNome());
		assertEquals(senha, usuario.getSenha());
		
	}
}
