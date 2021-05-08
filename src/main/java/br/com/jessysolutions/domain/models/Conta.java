package br.com.jessysolutions.domain.models;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Embedded
	private Cliente cliente;

	@NotEmpty
	@Size(min = 4, max = 5)
	private String agencia;

	@NotEmpty
	@Size(min = 8, max = 8)
	private String numeroDaConta;

	@NotEmpty
	@Size(min = 1, max = 1)
	private String digitoVerificador;

	@NotNull
	@PositiveOrZero
	private BigDecimal saldo;

	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

}
