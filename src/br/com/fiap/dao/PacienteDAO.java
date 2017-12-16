package br.com.fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.interf.IPacienteDAO;
import br.com.fiap.entity.Paciente;

public class PacienteDAO extends DAO<Paciente> implements IPacienteDAO {

	protected EntityManager em;
	public PacienteDAO(EntityManager em) {
		super(em);
		this.em = em;
	}
	
	public Paciente findByCpf(String cpf) {
		Paciente p = new Paciente();
		TypedQuery<Paciente> query = em.createQuery("from Paciente p where p.id like :id", Paciente.class);
		query.setParameter("id", cpf);
		p = query.getSingleResult();
		return p;
	}
	
}
