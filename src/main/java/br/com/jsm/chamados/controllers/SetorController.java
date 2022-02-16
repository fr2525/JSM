package br.com.jsm.chamados.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.jsm.chamados.models.SetorModel;

@Controller
public class SetorController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;
	

	public void edit(SetorModel setor) {
		result.include("setor", setor);

	}

	public void list() {
		Query query = this.entityManager.createQuery("from setorModel");
		List<SetorModel> setores = query.getResultList();
		result.include("setores", setores);
	}
	
	public void save(SetorModel setor) {
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
