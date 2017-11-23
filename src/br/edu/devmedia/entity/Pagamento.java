package br.edu.devmedia.entity;

public class Pagamento {
	
	private int id;
	private String paypal_id;
	private Double valor;
	private String moeda;
	private Usuario usuario;
	private String estado;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaypal_id() {
		return paypal_id;
	}
	public void setPaypal_id(String paypal_id) {
		this.paypal_id = paypal_id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
