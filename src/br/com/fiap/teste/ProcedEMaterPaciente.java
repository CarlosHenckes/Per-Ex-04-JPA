package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.Paciente;
import br.com.fiap.util.JPAUtil;

public class ProcedEMaterPaciente {

	public static void main(String[] args) {
		
		final EntityManager em;
		em = JPAUtil.getEntityManager();
		
		PacienteDAO dao = new PacienteDAO(em);
		Paciente p = new Paciente();
		try {
			em.getTransaction().begin();
			p = dao.findByCpf("15683857813");
			
			System.out.println("Paciente: "+ p.toString());
			System.out.println("------------------------------");
			System.out.println("Procedimentos: ");
			
			p.getProcedimentos().forEach(System.out::println);
			
			System.out.println("");
			System.out.println("Materiais: ");
			
			p.getMateriais().forEach(System.out::println);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
