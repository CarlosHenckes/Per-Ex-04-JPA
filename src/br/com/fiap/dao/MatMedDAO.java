package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.dao.interf.IMatMedDAO;
import br.com.fiap.entity.MatMed;

public class MatMedDAO extends DAO<MatMed> implements IMatMedDAO {

	protected EntityManager em;
	public MatMedDAO(EntityManager em) {
		super(em);
	}

}
