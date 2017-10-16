package br.edu.devmedia.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.entity.Produto;

@Path("/produtos")
public class ProdutoService {
	
	@GET
	@Path("/index")	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listProfissoes() {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto produto = new Produto(
			1,
			"img/produtos/caderno_de_desenho.jpg",
			"Caderno de Desenho",
			"Caderno de desenho com capa dura estampada e prendedor elástico.",
			new BigDecimal("56.78")
		);
		
		Produto produto2 = new Produto(
				2,
				"img/produtos/lapis_de_cor.jpg",
				"Ecolápis de Cor",
				"Conjunto de lápis de cor ecológico.",
				new BigDecimal("31.49")
			);
		
		Produto produto3 = new Produto(
				3,
				"img/produtos/mochila.jpg",
				"Mochila",
				"Mochila resistente, apropriada para uso escolar, viagens e transporte de pequenos objetos em geral.",
				new BigDecimal("359.69")
			);
		
		produtos.add(produto);
		produtos.add(produto2);
		produtos.add(produto3);
		
		return produtos;
		
	}

}
