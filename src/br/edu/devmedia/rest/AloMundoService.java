package br.edu.devmedia.rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.entity.Pessoa;
import br.edu.devmedia.util.Constantes;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

@Path("/")
public class AloMundoService {
	
	@GET
	public String aloMundo() {
		
		return "Alô, mundo!";
		
	}
	
	@GET
	@Path("/alo")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_PLAIN)
	public String alo(@QueryParam("msg") String msg) {
		
		return "<h1>Alô, mundo: " + msg + "!</h1>";
		
	}
	
	@GET
	@Path("/param/{msg}")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_PLAIN)
	public String textParam(@PathParam("msg") String msg) {
		
		return "<h1>Alô, parâmetro: " + msg + "!</h1>";
		
	}
	
	@POST
	@Path("/json")
	@Produces(Constantes.APPLICATION_JSON_UTF8)
	@Consumes(Constantes.APPLICATION_JSON_UTF8)
	public Pessoa testJson(Pessoa p) {
		
		Map<String, Pessoa> irmaos = new HashMap<String, Pessoa>();
		Pessoa[] filhos = new Pessoa[5];
		for(int i = 0; i < 5; i++) {
			
			Pessoa filho = new Pessoa();
			filho.setNome("Filho " + i);
			filhos[i] = filho;
			
			Pessoa irmao = new Pessoa();
			irmao.setNome("Irmão " + i);
			irmaos.put(String.valueOf(i), irmao);
			
		}
		p.setFilhos(filhos);
		p.setIrmaos(irmaos);
		return p;
		
	}

}
