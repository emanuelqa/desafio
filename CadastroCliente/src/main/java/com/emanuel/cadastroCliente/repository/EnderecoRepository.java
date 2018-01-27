package com.emanuel.cadastroCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanuel.cadastroCliente.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
