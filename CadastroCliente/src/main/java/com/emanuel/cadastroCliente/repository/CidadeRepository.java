package com.emanuel.cadastroCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanuel.cadastroCliente.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
