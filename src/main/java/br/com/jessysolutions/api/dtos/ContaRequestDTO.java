package br.com.jessysolutions.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.jessysolutions.domain.models.Cliente;
import br.com.jessysolutions.domain.models.Conta;

public class ContaRequestDTO {

	@NotEmpty
	private String nomeCliente;

	@NotEmpty
	private String emailCliente;

	@NotEmpty
	private String cpfCliente;

	@NotEmpty
	private String telefoneCliente;

	@NotEmpty
	private String sexoCliente;

	@NotNull
	private Date dataDeNascimento;

	@NotEmpty
	private String senha;

	@NotEmpty
	@Size(min = 4, max = 5)
	private String agencia;

	@NotEmpty
	@Size(min = 8, max = 8)
	private String numeroDaConta;

	@NotEmpty
	@Size(min = 1, max = 1)
	private String digitoVerificador;

	public ContaRequestDTO(@NotEmpty String nomeCliente, @NotEmpty String emailCliente, @NotEmpty String cpfCliente,
			@NotEmpty String telefoneCliente, @NotEmpty String sexoCliente, @NotNull Date dataDeNascimento,
			@NotEmpty String senha, @NotEmpty @Size(min = 4, max = 5) String agencia,
			@NotEmpty @Size(min = 8, max = 8) String numeroDaConta,
			@NotEmpty @Size(min = 1, max = 1) String digitoVerificador) {
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.cpfCliente = cpfCliente;
		this.telefoneCliente = telefoneCliente;
		this.sexoCliente = sexoCliente;
		this.dataDeNascimento = dataDeNascimento;
		this.senha = senha;
		this.agencia = agencia;
		this.numeroDaConta = numeroDaConta;
		this.digitoVerificador = digitoVerificador;
	}

	public Conta toModel() {

		Cliente cliente = new Cliente(nomeCliente, emailCliente, cpfCliente, telefoneCliente, sexoCliente,
				dataDeNascimento, senha);
		BigDecimal saldo = BigDecimal.ZERO;

		Conta conta = new Conta(cliente, agencia, numeroDaConta, digitoVerificador, saldo);

		return conta;
	}

}
