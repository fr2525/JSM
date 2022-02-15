package br.com.jsm.chamados.models;

import br.com.jsm.chamados.types.StChamadoType;

public class ChamadosModel {
	private int idChamado;
	private String dsChamado;
	private UsuarioModel usuarioSolicitante;
	private SetorModel setorDestino;
	private StChamadoType stChamado;
	public int getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}
	public String getDsChamado() {
		return dsChamado;
	}
	public void setDsChamado(String dsChamado) {
		this.dsChamado = dsChamado;
	}
	public UsuarioModel getUsuarioSolicitante() {
		return usuarioSolicitante;
	}
	public void setUsuarioSolicitante(UsuarioModel usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}
	public SetorModel getSetorDestino() {
		return setorDestino;
	}
	public void setSetorDestino(SetorModel setorDestino) {
		this.setorDestino = setorDestino;
	}
	public StChamadoType getStChamado() {
		return stChamado;
	}
	public void setStChamado(StChamadoType stChamado) {
		this.stChamado = stChamado;
	}
	
	// Situacao chamado
	
}
