package br.com.jessysolutions.domain.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Embeddable
public class Cliente {

	@Column(name = "nome_cliente")
	@NotEmpty
	private String nome;

	@Column(name = "email_cliente")
	@NotEmpty
	@Email
	private String email;

	@Column(name = "cpf_cliente")
	@NotEmpty
	@Size(min = 11, max = 11)
	private String cpf;

	@Column(name = "telefone_cliente")
	@NotEmpty
	private String telefone;

	@Column(name = "genero_cliente")
	@NotEmpty
	private String sexo;

	@Column(name = "data_nascimento_cliente")
	@NotNull
	@Past
	private Date dataDeNascimento;

	@Column(name = "senha_cliente")
	@NotEmpty
	private String senha;

	public Cliente() {
	}

	public Cliente(@NotEmpty String nome, @NotEmpty @Email String email, @NotEmpty @Size(min = 11, max = 11) String cpf,
			@NotEmpty String telefone, @NotEmpty String sexo, @NotNull @Past Date dataDeNascimento,
			@NotEmpty String senha) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getSenha() {
		return senha;
	}

}
