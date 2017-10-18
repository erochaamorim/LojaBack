package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.config.DatabaseConfig;
import br.edu.devmedia.entity.Produto;

public class ProdutoDAO {
	
	public List<Produto> listarProdutos() throws Exception {
		
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conexao = DatabaseConfig.getInstance().getConnection();
		String sql = "SELECT * FROM produto";
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next() ) {
			
			Produto produto = new Produto();
			produto.setId(rs.getInt("id"));
			produto.setTitulo(rs.getString("titulo"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setValor(rs.getBigDecimal("valor"));
			produto.setUrlImg(rs.getString("url"));
			produtos.add(produto);
			
		}
		return produtos;
		
	}

}
