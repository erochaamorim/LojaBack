package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.config.DatabaseConfig;
import br.edu.devmedia.entity.User;
import br.edu.devmedia.entity.Usuario;
import br.edu.devmedia.util.CryptoUtil;

public class UsuarioDAO {
	
	public boolean isLoggedIn(String login, String senha) throws Exception {
		
		
		Connection conexao = DatabaseConfig.getInstance().getConnection();
		
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, CryptoUtil.cryptoStringHexMD5(senha) );
		ResultSet resultSet = statement.executeQuery();
		return resultSet.next();
		
	}
	
	public boolean inserirToken(String login, String token) throws Exception {
		
		Connection conexao = DatabaseConfig.getInstance().getConnection();		
		String sql = "UPDATE usuario SET fcm_token = ? WHERE login = ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, token);
		statement.setString(2, login);
		return statement.execute();
		
	}
	
	public List<Usuario> listarUsuarios() throws Exception {
		
		Connection conexao = DatabaseConfig.getInstance().getConnection();		
		String sql = "SELECT * FROM usuario";
		PreparedStatement statement = conexao.prepareStatement(sql);		
		ResultSet resultSet = statement.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();
		while(resultSet.next() ) {
			
			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getInt("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setFcmToken(resultSet.getString("fcm_token"));
			lista.add(usuario);
			
		}
		
		return lista;
		
	}
	
	public Usuario buscarUsuarioPorLogin(String login) throws Exception {
		
		Connection conexao = DatabaseConfig.getInstance().getConnection();		
		String sql = "SELECT * FROM usuario WHERE login = ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, login);
		ResultSet resultSet = statement.executeQuery();
		Usuario usuario = null;
		if(resultSet.next() ) {
			
			usuario = new Usuario();
			usuario.setId(resultSet.getInt("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setFcmToken(resultSet.getString("fcm_token"));			
			
		}
		
		return usuario;
		
	}

}
