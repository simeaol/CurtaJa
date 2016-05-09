package br.curtaja.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="eventos")
public class Evento {
	
	@Id
	@NotNull
	@SequenceGenerator(name="evSeq", sequenceName="eventos_idEventos_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,  generator="evSeq")
	private int idEvento;
	
	@NotNull
	@Column(name="evento_nome")
	private String nomeEvento;
	
	@NotNull
	@Column(name="evento_data")
	private String data;
	
	@NotNull
	@Column(name="evento_endereco")
	private String endereco;
	
	@NotNull
	@Column(name="evento_cidade")
	private String cidade;
	
	@NotNull
	@Column(name="evento_descricao")
	private String descricao;
	
	@NotNull
	@Column(name="preco")
	private double preco;
	
	@NotNull
	@Column(name="evento_image_path")
	private String imagem;
	
	@NotNull
	//@OneToMany(targetEntity=Cliente.class)
	@Column(name="evento_idCliente")
	private int evento_idCliente;
	
	
	//Constructors	
	public Evento(){
		
	}
	
	public Evento(String data, String endereco, String cidade, String descricao,
			double preco, String imagem, int evento_idCliente) {
		super();
		this.data = data;
		this.endereco = endereco;
		this.cidade = cidade;
		this.descricao = descricao;
		this.preco = preco;
		this.imagem = imagem;
		this.evento_idCliente = evento_idCliente;
	}

	//Getters and Setters
	public int getIdEvento() {
		return idEvento;
	}
	
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getEvento_idCliente() {
		return evento_idCliente;
	}

	public void setEvento_idCliente(int evento_idCliente) {
		this.evento_idCliente = evento_idCliente;
	}

	@Override
	public String toString() {
		return String.format(
				"Evento [idEvento=%s, nomeEvento=%s, data=%s, endereco=%s, cidade=%s, descricao=%s, preco=%s, imagem=%s, evento_idCliente=%s]",
				idEvento, nomeEvento, data, endereco, cidade, descricao, preco, imagem, evento_idCliente);
	}

}
