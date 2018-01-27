package com.emanuel.cadastroCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanuel.cadastroCliente.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
