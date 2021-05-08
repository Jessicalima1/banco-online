package br.com.jessysolutions.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jessysolutions.domain.models.Conta;
import br.com.jessysolutions.domain.repositories.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@PostMapping
	public ResponseEntity<Conta> adicionar(@RequestBody @Valid Conta conta, UriComponentsBuilder uriComponentsBuilder) {

		Conta save = contaRepository.save(conta);

		return ResponseEntity.created(uriComponentsBuilder.path("/contas/{id}").buildAndExpand(save.getId()).toUri())
				.body(save);

	}
}
