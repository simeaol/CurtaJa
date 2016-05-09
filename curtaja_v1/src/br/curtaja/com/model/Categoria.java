package br.curtaja.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@NotNull
	@Column(name="idCategoria")
	@SequenceGenerator(name="catSeq", sequenceName="Categorias_idCategoria_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="catSeq")
	private int idCategoria;
	
	@NotNull
	@Column(name="categoria_nome")
	private String nomeCategoria;
	
	
	//Constructors	
	public Categoria(){	
		
	}
	
	public Categoria(int id, String nome){
		this.idCategoria = id;
		this.nomeCategoria = nome;		
	}

	
	//Getters and Setters
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	

}
