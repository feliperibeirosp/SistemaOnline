package sco.infra;



import sco.controller.UsuarioController;
import sco.model.UsuarioWeb;
import sco.notacao.Restrito;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

public class AutenticacaoInterceptor implements Interceptor{
	
	private final UsuarioWeb usuario;
	private final Result result;
	
	public AutenticacaoInterceptor(UsuarioWeb usuario,Result result){
		this.usuario = usuario;
		this.result = result;
	}
	@Override
	public boolean accepts(ResourceMethod method) {
		
		return !this.usuario.isLogado() && method.containsAnnotation(Restrito.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(UsuarioController.class).loginForm();
		
	}

}
