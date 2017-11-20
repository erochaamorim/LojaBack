package br.edu.devmedia.entity;

/**
 * Created by erick.amorim on 02/10/2017.
 */

public class Usuario {

    protected int id;
    protected String login;
    protected String senha;
    protected String fcmToken;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}   
    
    
    
}

