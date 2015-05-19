package org.demoiselle.sample.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="TB_Funcionario")
public class Funcionario extends Pessoa implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
    @Temporal(value=TemporalType.DATE)
    private Date dataMatricula;
	
	@Column
	private Integer numeroMatricula;
	
	@Column
	private String email;
	
	/*@ManyToOne 
	@JoinColumn (name= "turma_fk")
	private Turma turma;*/
	
	/*@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BolsaEstudo bolsaEstudo;*/
		
	
	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_estudante_endereco", joinColumns = @JoinColumn(name = "id_funcionario"), 
	           inverseJoinColumns = @JoinColumn(name = "cod_endereco"))
	private List<Endereco> enderecos;

	public Funcionario(){
		super();
	}

	public Funcionario(Date dataMatricula, Integer numeroMatricula, Long cpf, String nome,
				Date dataNascimento,String email, Genero genero) {
		super(cpf, nome, dataNascimento, genero);
		this.dataMatricula = dataMatricula;
		this.numeroMatricula = numeroMatricula;
		this.email = email;
	}
		
	
	public Funcionario(Date dataMatricula, Integer numeroMatricula,
					 BolsaEstudo bolsaEstudo, List<Endereco> enderecos, Long cpf, 
					 String nome, Date dataNascimento, String email, Genero genero) {
		super(cpf, nome, dataNascimento, genero);
		this.dataMatricula = dataMatricula;
		//this.setTurma(turma);
		this.numeroMatricula = numeroMatricula;
		//this.bolsaEstudo = bolsaEstudo;
		this.setEnderecos(enderecos);
		this.email = email;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	
//	public BolsaEstudo getBolsaEstudo() {
//		return bolsaEstudo;
//	}
//
//	public void setBolsaEstudo(BolsaEstudo bolsaEstudo) {
//		this.bolsaEstudo = bolsaEstudo;
//	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


}
