package br.edu.devmedia.rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

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
	@Path("param/{msg}")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_PLAIN)
	public String textParam(@PathParam("msg") String msg) {
		
		return "<h1>Alô, parâmetro: " + msg + "!</h1>";
		
	}

}
