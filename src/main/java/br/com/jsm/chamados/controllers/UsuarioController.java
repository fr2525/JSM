package br.com.jsm.chamados.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.business.SetorBO;
import br.com.jsm.chamados.business.UsuarioBO;
import br.com.jsm.chamados.models.UsuarioModel;
import br.com.jsm.chamados.types.StUsuarioType;

@Controller
public class UsuarioController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	private UsuarioBO usuarioBO;
	private SetorBO setorBO;
	
	public void edit(UsuarioModel usuario) {
		setorBO = new SetorBO();
		
		result.include("setores", setorBO.getListSetor(entityManager));
		result.include("situacoes", StUsuarioType.values());
		result.include("usuario", usuario);

	}

	@SuppressWarnings("unchecked")
	public void list() {
		Query query = this.entityManager.createQuery("from UsuarioModel");
		List<UsuarioModel> usuarios = query.getResultList();
		result.include("usuarios", usuarios);
	}
	
	public void save(UsuarioModel usuario) throws Exception {
		validator.validate(usuario);

		if (usuario.getSetor().getIdSetor() == 0) {
			validator.add(new I18nMessage("idSetor", "not.blank"));
		}

		if (usuario.getStUsuario() .equals(StUsuarioType.SELECIONE)) {
			validator.add(new I18nMessage("stUsuario", "not.blank"));
		}

		if (! validator.hasErrors()) {
			if (! usuario.getDsSenha().equals("")) {
				if (! usuario.getDsSenha().equals(usuario.getDsSenhaConfirm())) {
					validator.add(new I18nMessage("dsSenha", "senha.nao.confere"));
				}
			}
		}
		
		validator.onErrorForwardTo(this).edit(usuario);
		
		usuarioBO = new UsuarioBO();
				
		if (! usuario.getDsSenha().equals("")) {
			String dsSenha = usuarioBO.encryptPassword(usuario.getDsSenha());
			usuario.setDsSenha(dsSenha);
		} else {
			if (usuario.getIdUsuario() != 0 ) {
				UsuarioModel usuarioBD = this.entityManager.find(UsuarioModel.class, usuario.getIdUsuario());
				usuario.setDsSenha(usuarioBD.getDsSenha());
			}
		}
		
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
