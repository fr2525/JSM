package br.com.jsm.chamados.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jsm.chamados.types.StChamadoType;

@Entity
@Table(name="CHAMADOS")
public class ChamadosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChamado;
	private String dsChamado;
	
	@OneToOne
	@JoinColumn(name= "idUsuario")
	private UsuarioModel usuarioSolicitante;
	
	@OneToOne
	@JoinColumn(name= "idSetor")
	private SetorModel setorDestino;
	
	private StChamadoType stChamado;
	private Date dtChamado;
	
	@OneToMany(mappedBy = "chamado")
	private Collection<AcompanhamentoModel> acompanhamentos;
	
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
	public Date getDtChamado() {
		return dtChamado;
	}
	public void setDtChamado(Date dtChamado) {
		this.dtChamado = dtChamado;
	}
	public Collection<AcompanhamentoModel> getAcompanhamentos() {
		return acompanhamentos;
	}
	public void setAcompanhamentos(Collection<AcompanhamentoModel> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}
	
	// Situacao chamado
	
}
