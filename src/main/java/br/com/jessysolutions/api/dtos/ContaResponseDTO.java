package br.com.jessysolutions.api.dtos;

import br.com.jessysolutions.domain.models.Conta;

public class ContaResponseDTO {

	private Integer id;
	private String nome;
	private String email;
	private String agencia;

	private String conta;

	public ContaResponseDTO(Conta conta) {

		this.id = conta.getId();
		this.nome = conta.getCliente().getNome();
		this.email = this.representarEmail(conta.getCliente().getEmail());
		this.agencia = conta.getAgencia();
		this.conta = this.representarConta(conta.getNumeroDaConta(), conta.getDigitoVerificador());
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	private String representarEmail(String email) {

		String tresPrimeirosDigitos = (String) email.subSequence(0, 3);
		String tresUltimosDigitos = email.substring(3);
		return tresPrimeirosDigitos + "*******" + tresUltimosDigitos;
	}

	private String representarConta(String numeroDaConta, String digitoVerificador) {
		return numeroDaConta + "-" + digitoVerificador;
	}

}
