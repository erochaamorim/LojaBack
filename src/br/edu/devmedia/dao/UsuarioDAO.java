package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.edu.devmedia.config.DatabaseConfig;
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

}
