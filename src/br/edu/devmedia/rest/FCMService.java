package br.edu.devmedia.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.UsuarioDAO;

@Path("fcm")
public class FCMService {
	
	protected UsuarioDAO usuarioDAO;
	
	@PostConstruct
	public void init() {
		
		usuarioDAO = new UsuarioDAO();
		
	}
	
	@POST
	@Path("/sendToken")	
	@Produces(MediaType.TEXT_PLAIN)
	public boolean getToken(@FormParam("login") String login, @FormParam("token") String token) {
		
		try {
			
			return usuarioDAO.inserirToken(login, token);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}
		
	}

}
