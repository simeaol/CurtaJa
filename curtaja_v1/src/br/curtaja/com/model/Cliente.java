package br.curtaja.com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="clientes")
public class Cliente {
	
	// attributes
	@Id
	@NotNull
	@Column(name="idCliente")
	@SequenceGenerator(name="cliSeq", sequenceName="clientes_idCliente_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliSeq")	
	 private int idCliente;
	 
	@Column(name="cliente_nome")
	 private String nome;
	
	@Column(name="cliente_email")
	 private String email;
	
	@Column(name="cliente_cpf")
	 private String cpf;
	
	@Column(name="cliente_nome_empresa")
	 private String empresa;
	
	@Column(name="cliente_idcategoria")
	 private int categoria;
	
	@Column(name="cliente_endereco")
	 private String endereco;
	
	@Column(name="cliente_cidade")
	 private String cidade;
	
	@Column(name="cliente_telefone")
	 private String telefone;
	
	@Column(name="cliente_senha")
	 private String senha;
	
	@Column(name="data_cadastro")
	 private Date dataCadastro;
	
	@Column(name="data_limite")
	 private Date dataLimite;
	
	//Colocar caminho do flyer no servidor
	@NotNull
	@Column(name="cliente_logo_path")
	 private String logo;
	
	@NotNull
	@Column(name="cliente_idplano")
	 int idPlano;
	
	//constructors
	 public Cliente(){
		 
	 }
	
	public Cliente(String nome, String email, String cpf, String empresa, int categoria, String endereco,
			String cidade, String telefone, String senha, Date dataCadastro, Date dataLimite, String logo,
			int idPlano) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.empresa = empresa;
		this.categoria = categoria;
		this.endereco = endereco;
		this.cidade = cidade;
		this.telefone = telefone;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.dataLimite = dataLimite;
		this.logo = logo;
		this.idPlano = idPlano;
	}



	// getters and setters
	@Column(name="cliente_id")
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	@Column(name="cliente_nome")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="cliente_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="cliente_cpf")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Column(name="cliente_empresa")
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	@Column(name="cliente_categoria")
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	@Column(name="cliente_endereco")
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column(name="cliente_cidade")
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	@Column(name="cliente_telefone")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(name="cliente_senha")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	@Column(name="data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name="data_limite")
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	@Column(name="cliente_logo_path")
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name="cliente_idplano")
	public int getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(int idPlano) {
		this.idPlano = idPlano;
	}

	@Override
	public String toString() {
		return String.format(
				"Cliente [idCliente=%s, nome=%s, email=%s, cpf=%s, empresa=%s, categoria=%s, endereco=%s, cidade=%s, telefone=%s, senha=%s, dataCadastro=%s, dataLimite=%s, logo=%s, idPlano=%s]",
				idCliente, nome, email, cpf, empresa, categoria, endereco, cidade, telefone, senha, dataCadastro,
				dataLimite, logo, idPlano);
	}

}
