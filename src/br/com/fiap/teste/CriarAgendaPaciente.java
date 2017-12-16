package br.com.fiap.teste;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.Paciente;
import br.com.fiap.util.JPAUtil;

public class CriarAgendaPaciente {

	public static void main(String[] args) {
		
		final EntityManager em;
		em = JPAUtil.getEntityManager();
		
		PacienteDAO dao = new PacienteDAO(em);
		em.getTransaction().begin();
		// criar um novo paciente com agenda
		// criar paciente
		Paciente paciente = new Paciente();
		paciente.setCpf("15683857813");
		paciente.setNome("Carlos Henckes");
		paciente.setTelefone("44532071");
		paciente.setDatanasc(new Date());
		
		// criar a agenda
		Set<Agenda> agendas = new HashSet<>();
		Agenda agenda = new Agenda();
		agenda.setData(new Date());
		agenda.setHora(new Date());
		agenda.setDescricao("Consulta Cardiologista");
		
		Set<Paciente> p = new HashSet<>();
		p.add(paciente);
		agenda.setPacientes(p);
		
		agendas.add(agenda);
		paciente.setAgendas(agendas);
		
		try {
			dao.insert(paciente);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
