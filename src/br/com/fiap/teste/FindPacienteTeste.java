package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.Paciente;
import br.com.fiap.util.JPAUtil;

public class FindPacienteTeste {

	public static void main(String[] args) {
		
		final EntityManager em;
		em = JPAUtil.getEntityManager();
		
		PacienteDAO dao = new PacienteDAO(em);
		try {
			Paciente p = dao.findByCpf("15683857813");
			System.out.println("Paciente: " + p.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
