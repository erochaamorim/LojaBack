package br.edu.devmedia.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.UsuarioDAO;
import br.edu.devmedia.entity.Content;
import br.edu.devmedia.entity.Usuario;
import br.edu.devmedia.util.Post2FCM;

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
	
	@GET
	@Path("/sendToAll")	
	@Produces(MediaType.TEXT_PLAIN)
	public String sendDefaultMsgToAllUsers() {
		
		String resultado = "Não foi possível enviar a mensagem para os seguintes usuários: ";
		try {
			
			Boolean sucesso = true;
			List<Usuario> usuarios = usuarioDAO.listarUsuarios();
			for(Usuario usuario : usuarios) {
				
				Boolean sucessoParcial = Post2FCM.postUnicast(criarContent(usuario.getFcmToken() ) );				
				if(!sucessoParcial) {
					
					resultado += usuario.getLogin();
					
				}
				sucesso = sucesso && sucessoParcial;				
				
			}
			if(sucesso) {
				
				resultado = "A mensagem foi enviada com sucesso para todos os usuários.";
				
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			resultado = "Erro: " + e.getMessage();
			
		}
		return resultado;
		
	}
	
	@GET
	@Path("/sendToUser")	
	@Produces(MediaType.TEXT_PLAIN)
	public String sendDefaultMsgToUser(@QueryParam("login") String login) {
		
		String resultado = "Não foi possível enviar a mensagem.";
		try {
			
			Usuario usuario = usuarioDAO.buscarUsuarioPorLogin(login);		
			if(Post2FCM.postUnicast(criarContent(usuario.getFcmToken() ) ) ) {
				
				resultado = "A mensagem foi enviada com sucesso.";
				
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			resultado = "Erro: " + e.getMessage();
			
		}
		return resultado;
		
	}
	
	private static Content criarContent(String fcmToken) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Content content = new Content();
		content.addRegId(fcmToken);
		content.addData("titulo", "Notificação Teste");
		content.addData("message", "Mensagem teste.");
		content.addData("data", simpleDateFormat.format(new Date() ) );
		content.addData("id", "2");
		content.addData("imgUrl", "https://d30y9cdsu7xlg0.cloudfront.net/png/1199198-200.png");
		return content;
		
	}

}
