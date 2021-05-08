package br.com.jessysolutions.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jessysolutions.domain.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
