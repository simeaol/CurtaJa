package br.curtaja.com.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="planos")
public class Plano {
	@Id
	@NotNull
	@SequenceGenerator(name="plaSeq", sequenceName="planos_idplano_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="plaSeq")	
	int idPlano;
	
	@NotNull
	@Column(name="plano_nome")
	String planoNome;
	
	@NotNull
	@Column(name="plano_preco")
	BigDecimal planoPreco; //melhor do que double por causa dos arredendomentos
	
	
	
	public Plano() {
		super();
	}
	
	public Plano(String plano, BigDecimal preco){
		this.planoNome = plano;
		this.planoPreco = preco;
	}
	
	
	public int getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(int idPlano) {
		this.idPlano = idPlano;
	}

	public String getPlanoNome() {
		return planoNome;
	}

	public void setPlanoNome(String planoNome) {
		this.planoNome = planoNome;
	}

	public BigDecimal getPlanoPreco() {
		return planoPreco;
	}

	public void setPlanoPreco(BigDecimal planoPreco) {
		this.planoPreco = planoPreco;
	}

}
