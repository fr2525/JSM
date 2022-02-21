package br.com.jsm.chamados.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.business.SetorBO;
import br.com.jsm.chamados.models.SetorModel;

@Controller
public class SetorController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	private SetorBO setorBO;
	
	public void edit(SetorModel setor) {
		result.include("setor", setor);

	}

	public void list() {
		setorBO = new SetorBO();
		result.include("setores", setorBO.getListSetor(entityManager));
	}
	
	public void save(SetorModel setor) {
		validator.validate(setor);
		validator.onErrorForwardTo(this).edit(setor);
		if (setor.getIdSetor() == 0) {
			create(setor);
		} else {
			update(setor);
		}
	}

	public void create(SetorModel setor) {
		this.entityManager.persist(setor);
		result.forwardTo(this).edit(null);
	}

	public void read(SetorModel setor) {
		SetorModel setorDB = this.entityManager.find(SetorModel.class, setor.getIdSetor());
		result.forwardTo(this).edit(setorDB);
	}

	public void update(SetorModel setor) {
		this.entityManager.merge(setor);
		result.forwardTo(this).edit(null);

	}

	public void delete(SetorModel setor) {
		SetorModel setorDB = this.entityManager.find(SetorModel.class, setor.getIdSetor());
		this.entityManager.remove(setorDB);
		result.forwardTo(this).edit(null);
		
	}
}
