package br.edu.devmedia.entity;

import java.util.Map;

public class Pessoa {

	protected String nome;
	protected Pessoa[] filhos;
	protected Map<String, Pessoa> irmaos;

	public Map<String, Pessoa> getIrmaos() {
		return irmaos;
	}

	public void setIrmaos(Map<String, Pessoa> irmaos) {
		this.irmaos = irmaos;
	}

	public Pessoa[] getFilhos() {
		
		return filhos;
		
	}

	public void setFilhos(Pessoa[] filhos) {
		
		this.filhos = filhos;
		
	}

	public String getNome() {
		
		return nome;
		
	}

	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
}
