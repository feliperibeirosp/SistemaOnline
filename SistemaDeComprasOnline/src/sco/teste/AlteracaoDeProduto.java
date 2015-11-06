package sco.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sco.dao.ProdutoDao;
import sco.infra.CriadorDeSession;
import sco.infra.CriadorDeSessionFactory;
import sco.model.Produto;

public class AlteracaoDeProduto {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		 
		 Session session = new CriadorDeSession(factory).getInstance();
		 ProdutoDao dao = new ProdutoDao(session);
		 
		 Produto produto = (Produto) session.load(Produto.class, 3L);
		
		 dao.atualiza(produto);
		
	}
}
