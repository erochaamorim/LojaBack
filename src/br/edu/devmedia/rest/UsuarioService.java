package br.edu.devmedia.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.UsuarioDAO;
import br.edu.devmedia.entity.Profissao;
import br.edu.devmedia.entity.User;

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
	public boolean isLoggedIn(@FormParam("login") String login, @FormParam("senha") String senha) {
		
		try {
			
			return usuarioDAO.isLoggedIn(login, senha);
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
			
		}
		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User add(User user) {
		
		return user;
		
	}
	
	@GET
	@Path("/profissoes")	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profissao> listProfissoes() {
		
		List<Profissao> profissoes = new ArrayList<Profissao>();
		
		Profissao profissao = new Profissao();
		profissao.setCod(1);
		profissao.setDescricao("Professor");
		profissao.setSubDescricao("Filosofia");
		profissao.setUrlImg("img/student.png");
		profissoes.add(profissao);
		
		Profissao profissao1 = new Profissao();
		profissao1.setCod(2);
		profissao1.setDescricao("Cientista");
		profissao1.setSubDescricao("Neurologia");
		profissao1.setUrlImg("img/brain.png");
		profissoes.add(profissao1);
		
		Profissao profissao2 = new Profissao();
		profissao2.setCod(3);
		profissao2.setDescricao("Psicólogo");
		profissao2.setSubDescricao("Análise do Comportamento");
		profissao2.setUrlImg("img/doctor.png");
		profissoes.add(profissao2);
		
		return profissoes;
		
	}

}
