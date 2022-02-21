package br.com.jsm.chamados.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import br.com.jsm.chamados.types.StUsuarioType;

@Entity
@Table(name = "USUARIO") 
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotBlank
	private String nmUsuario;
	
	private String nrTelefone;
	
	@NotBlank
	private String dsEmail;
	
	@NotBlank
	@OneToOne
	@JoinColumn(name = "idSetor")
	private SetorModel setor;

	@NotBlank
	private String dsSenha;
	
	@Transient
	private String dsSenhaConfirm;
	

	@NotBlank
	private StUsuarioType stUsuario; 
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getDsSenhaConfirm() {
		return dsSenhaConfirm;
	}
	public void setDsSenhaConfirm(String dsSenhaConfirm) {
		this.dsSenhaConfirm = dsSenhaConfirm;
	}
	
	
}
