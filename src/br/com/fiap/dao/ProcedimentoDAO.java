package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.dao.interf.IProcedimentoDAO;
import br.com.fiap.entity.Procedimento;

public class ProcedimentoDAO extends DAO<Procedimento> implements IProcedimentoDAO {

	protected EntityManager em;
	
	public ProcedimentoDAO(EntityManager em) {
		super(em);
	}


}
