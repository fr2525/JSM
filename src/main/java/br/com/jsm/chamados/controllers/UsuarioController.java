package br.com.jsm.chamados.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.models.UsuarioModel;

@Controller
public class UsuarioController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	public void edit(UsuarioModel usuario) {
		result.include("usuario", usuario);

	}

	public void list() {
		Query query = this.entityManager.createQuery("from UsuarioModel");
		List<UsuarioModel> usuarios = query.getResultList();
		result.include("usuarios", usuarios);
	}
	
	public void save(UsuarioModel usuario) {
		validator.validate(usuario);
		validator.onErrorForwardTo(this).edit(usuario);
		if (usuario.getIdUsuario() == 0) {
			create(usuario);
		} else {
			update(usuario);
		}
	}

	public void create(UsuarioModel usuario) {
		this.entityManager.persist(usuario);
		result.forwardTo(this).edit(null);
	}

	public void read(UsuarioModel usuario) {
		UsuarioModel usuarioDB = this.entityManager.find(UsuarioModel.class, usuario.getIdUsuario());
		result.forwardTo(this).edit(usuarioDB);
	}

	public void update(UsuarioModel usuario) {
		this.entityManager.merge(usuario);
		result.forwardTo(this).edit(null);

	}

	public void delete(UsuarioModel usuario) {
		UsuarioModel usuarioDB = this.entityManager.find(UsuarioModel.class, usuario.getIdUsuario());
		this.entityManager.remove(usuarioDB);
		result.forwardTo(this).edit(null);
		
	}
}
