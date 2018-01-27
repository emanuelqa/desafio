package com.emanuel.cadastroCliente;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emanuel.cadastroCliente.domain.Cidade;
import com.emanuel.cadastroCliente.domain.Cliente;
import com.emanuel.cadastroCliente.domain.Endereco;
import com.emanuel.cadastroCliente.domain.Estado;
import com.emanuel.cadastroCliente.domain.enums.TipoPessoaEnum;
import com.emanuel.cadastroCliente.repository.CidadeRepository;
import com.emanuel.cadastroCliente.repository.ClienteRepository;
import com.emanuel.cadastroCliente.repository.EnderecoRepository;
import com.emanuel.cadastroCliente.repository.EstadoRepository;

@SpringBootApplication
public class CadastroClienteApplication implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroClienteApplication.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {
		
		Estado est = new Estado(null, "Paraíba");
		
		Cidade cit = new Cidade(null, "João Pessoa", est);
		
		est.getCidades().addAll(Arrays.asList(cit));
		
		estadoRepository.save(Arrays.asList(est));
		cidadeRepository.save(Arrays.asList(cit));
		
		Endereco endereco = new Endereco(null, "Sergipe", "491", "APTO 203", "Estados", "58030190", cit);
		Cliente cli = new Cliente(null, "Emanuel", "emanuel.qa@gmail.com", "123456789", endereco, TipoPessoaEnum.PESSOAFISICA);
		
		
		
		
		enderecoRepository.save(Arrays.asList(endereco));
		clienteRepository.save(Arrays.asList(cli));
		
		
		
		
	}
}
