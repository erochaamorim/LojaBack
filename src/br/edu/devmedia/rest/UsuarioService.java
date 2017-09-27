package br.edu.devmedia.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.UsuarioDAO;

@Path("/user")
public class UsuarioService {

	protected UsuarioDAO usuarioDAO;
	
	@PostConstruct
	public void init() {
		
		usuarioDAO = new UsuarioDAO();
		
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean isLoggedIn(@QueryParam("login") String login, @QueryParam("senha") String senha) {
		
		try {
			
			return usuarioDAO.isLoggedIn(login, senha);
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
			
		}
		
	}
	
}
