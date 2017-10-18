package br.edu.devmedia.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.ProdutoDAO;
import br.edu.devmedia.entity.Produto;

@Path("/produtos")
public class ProdutoService {
	
	protected ProdutoDAO produtoDAO;
	
	@PostConstruct
	public void init() {
		
		produtoDAO = new ProdutoDAO();
		
	}
	
	@GET
	@Path("/index")	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listProfissoes() {
		
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			produtos = produtoDAO.listarProdutos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
		
	}

}
