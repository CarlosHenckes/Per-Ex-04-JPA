package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.dao.interf.IAgendaDAO;
import br.com.fiap.entity.Agenda;

public class AgendaDAO extends DAO<Agenda> implements IAgendaDAO {
	
	protected EntityManager em;
	public AgendaDAO(EntityManager em) {
		super(em);
	}

}
