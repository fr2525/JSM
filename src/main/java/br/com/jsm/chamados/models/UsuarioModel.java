package br.com.jsm.chamados.models;

import br.com.jsm.chamados.types.StUsuarioType;

public class UsuarioModel {
	private int dUsuario;
	private String nmUsuario;
	private String nrTelefone;
	private String dsEmail;
	private StUsuarioType stUsuario; 
	
	// Setor
	private SetorModel setor;
	private String dsSenha;
	// Situacao
	public int getdUsuario() {
		return dUsuario;
	}
	public void setdUsuario(int dUsuario) {
		this.dUsuario = dUsuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	public SetorModel getSetor() {
		return setor;
	}
	public void setSetor(SetorModel setor) {
		this.setor = setor;
	}
	public StUsuarioType getStUsuario() {
		return stUsuario;
	}
	public void setStUsuario(StUsuarioType stUsuario) {
		this.stUsuario = stUsuario;
	}
	
	
}
