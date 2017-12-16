package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cpfpac", length = 11)
	private String cpf;
	
	@Column(length = 45)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date datanasc;
	
	@Column(length = 20)
	private String telefone;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Agenda_Paciente", joinColumns = {
			@JoinColumn(name = "paciente_cpf") }, inverseJoinColumns = { 
			@JoinColumn(name = "agenda_id") })
	private Set<Agenda> agendas = new HashSet<>();
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private Set<Procedimento> procedimentos = new HashSet<>();
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private Set<MatMed> materiais = new HashSet<>();

	public Paciente() {	}

	public Paciente(String cpf, String nome, Date datanasc, String telefone, Set<Agenda> agendas,
			Set<Procedimento> procedimentos, Set<MatMed> materiais) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.datanasc = datanasc;
		this.telefone = telefone;
		this.agendas = agendas;
		this.procedimentos = procedimentos;
		this.materiais = materiais;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Set<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Set<MatMed> getMateriais() {
		return materiais;
	}

	public void setMateriais(Set<MatMed> materiais) {
		this.materiais = materiais;
	}

	@Override
	public String toString() {
		return cpf + " - " + nome + " - " + datanasc + " - " + telefone;
	}
}
