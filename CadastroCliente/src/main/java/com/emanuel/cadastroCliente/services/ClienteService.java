package com.emanuel.cadastroCliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.emanuel.cadastroCliente.domain.Cidade;
import com.emanuel.cadastroCliente.domain.Cliente;
import com.emanuel.cadastroCliente.domain.Endereco;
import com.emanuel.cadastroCliente.domain.enums.TipoPessoaEnum;
import com.emanuel.cadastroCliente.dto.ClienteDTO;
import com.emanuel.cadastroCliente.exception.ObjectNotFoundExcepition;
import com.emanuel.cadastroCliente.repository.CidadeRepository;
import com.emanuel.cadastroCliente.repository.ClienteRepository;
import com.emanuel.cadastroCliente.repository.EnderecoRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//Realiza uma busca de clientes por id, retornando um cliente, caso o cliente não seja encontrado é retornado uma excessão.
	public Cliente busca(Integer id){
		Cliente cliente = clienteRepository.findOne(id);
		
		if(cliente == null){
			throw new ObjectNotFoundExcepition("Objeto não encontrado");
		}
		return cliente;
	}
	
	//Retorna uma lista com todos os clientes
	public List<Cliente> clientesAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}
	
	//Realiza uma pesquisa com base nas informações passada, com o intuito de fazer buscas por paginação.
	public Page<Cliente> clientesPage(Integer page, Integer linhasPage, String orderBy, String direcao){
		PageRequest pageRequest = new PageRequest(page, linhasPage, Direction.valueOf(direcao), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	//Insere um cliente na base de dados
	public Cliente insert(Cliente cliente){
		enderecoRepository.save(cliente.getEndereco());
		cliente = clienteRepository.save(cliente);
		return cliente;
	}
	
	//Realiza uma edição de um cliente
	public Cliente update(Cliente cliente){
		enderecoRepository.save(cliente.getEndereco());
		cliente = clienteRepository.save(cliente);
		return cliente;
	}
	
	//Popula um cliente apartir de um cliente DTO, retornando este cliente
	public Cliente fromDTO(ClienteDTO clienteDto){
		Cidade cidade = cidadeRepository.findOne(clienteDto.getCidadeId());
		Endereco endereco = new Endereco(null, clienteDto.getRua(), clienteDto.getNome(), clienteDto.getComplemento(), clienteDto.getBairro(), clienteDto.getCep(), cidade);
		Cliente cliente = new Cliente(null, clienteDto.getNome(), clienteDto.getEmail(), clienteDto.getCpfOuCnpj(),endereco, TipoPessoaEnum.toEnum(clienteDto.getTipo()));
		return cliente;
	}
}
