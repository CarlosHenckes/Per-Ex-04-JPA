package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MatMedDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.MatMed;
import br.com.fiap.entity.Paciente;
import br.com.fiap.util.JPAUtil;

public class NewMaterPacTeste {

	public static void main(String[] args) {
		// materiais e procedimento para um paciente
		
				final EntityManager em;
				em = JPAUtil.getEntityManager();
				PacienteDAO dao = new PacienteDAO(em);
				
				try {
					// encontrar paciente
					em.getTransaction().begin();
					Paciente p = dao.findByCpf("15683857813");
					
					// materias usados
					MatMed mat = new MatMed();
					mat.setDescricao("Pinça");
					mat.setFabricante("Labore s/a");
					mat.setPreco(32.0D);
					mat.setPaciente(p);
					// persist materias usados no procedimento
					MatMedDAO mDAO = new MatMedDAO(em);
					mDAO.insert(mat);
					em.getTransaction().commit();
					System.out.println("material lançado");
					
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

}
