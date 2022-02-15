package br.com.jsm.chamados.models;

import java.util.Collection;

public class SetorModel {
	
	private int idSetor;
	private String nmSetor;
	
	private Collection<UsuarioModel> usuariosList;
	
	public int getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}
	public String getNmSetor() {
		return nmSetor;
	}
	public void setNmSetor(String nmSetor) {
		this.nmSetor = nmSetor;
	}
	public Collection<UsuarioModel> getUsuariosList() {
		return usuariosList;
	}
	public void setUsuariosList(Collection<UsuarioModel> usuariosList) {
		this.usuariosList = usuariosList;
	}
	
}
