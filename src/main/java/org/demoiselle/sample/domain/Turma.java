package org.demoiselle.sample.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_Turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_turma")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 255)
	@NotNull
	private String nomeTurma;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "turma_fk")
	private List<Estudante> estudantes = new ArrayList<Estudante>();

	public Turma() {
		super();
	}

	public Turma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	
	public Turma(String nomeTurma, List<Estudante> estudantes) {
		this.nomeTurma = nomeTurma;
		this.estudantes = estudantes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public List<Estudante> getEstudantes() {
		return estudantes;
	}
	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
}
