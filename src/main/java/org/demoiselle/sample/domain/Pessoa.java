package org.demoiselle.sample.domain;

import java.util.Date;
import javax.persistence.*;


@MappedSuperclass
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@Column
    private Long cpf;
	
	@Column(nullable=false,  length=255)
    private String nome;
	
	@Column(nullable=false)
    @Temporal(value=TemporalType.DATE)
    private Date dataNascimento;
    
    @Enumerated(EnumType.STRING)
	@Column (length=10)
	private Genero genero;
	
	public Pessoa(){
    	super();
    }
	
	public Pessoa(Long cpf, String nome, Date dataNascimento, Genero genero) {		
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
