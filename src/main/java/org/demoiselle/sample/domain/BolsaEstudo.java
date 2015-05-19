package org.demoiselle.sample.domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "TB_Bolsa")
public class BolsaEstudo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_bolsa")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numero;

	@Column
	private Long porcentagem;

	@Column(nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date dataInicio;

	@Column
	@Temporal(value = TemporalType.DATE)
	private Date dataFim;

	public BolsaEstudo() {
		super();
	}

	public BolsaEstudo(Long porcentagem, Date dataInicio,
			Date dataFim) {
		super();
		this.porcentagem = porcentagem;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Long porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
