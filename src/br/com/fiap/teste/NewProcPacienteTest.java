package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;
import br.com.fiap.util.JPAUtil;

public class NewProcPacienteTest {

	public static void main(String[] args) {
		// material para paciente
		
		final EntityManager em;
		em = JPAUtil.getEntityManager();
		PacienteDAO dao = new PacienteDAO(em);
		
		try {
			// encontrar paciente
			em.getTransaction().begin();
			Paciente p = dao.findByCpf("15683857813");
			
			// adicionar o procedimento
			Procedimento proc = new Procedimento();
			proc.setDescricao("Consulta");
			proc.setPreco(120.0D);
			proc.setPaciente(p);
			// persist procedimento realizado
			ProcedimentoDAO pDAO = new ProcedimentoDAO(em);
			pDAO.insert(proc);
			em.getTransaction().commit();
			System.out.println("procedimento lançado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
