package com.emanuel.cadastroCliente.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emanuel.cadastroCliente.domain.Cliente;
import com.emanuel.cadastroCliente.dto.ClienteDTO;
import com.emanuel.cadastroCliente.services.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente/{id}")
	@ApiOperation(value = "Retorna um cliente passando o ID")
	public ResponseEntity<?> cliente(@PathVariable Integer id){
		Cliente cliente = clienteService.busca(id);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/clientes")
	@ApiOperation(value = "Retorna uma lista de todos os clientes cadastrados")
	public ResponseEntity<?> clientes(){
		return ResponseEntity.ok(clienteService.clientesAll());
	}
	
	@GetMapping(value = "/clientes/page")
	@ApiOperation(value = "Retorna uma lista de clientes cadastrados por paginas",notes="Na URL pode ser passado (Opcional) as variaveis "
			+ "page (padrão 0), linhas de páginas(padrão 5), ordenação (padrão id) e direcao (padrão acedente)."
			+ "ex: ip/clientes/page?page=2$linhasPage=2&orderBy=nome&direcao=ASC")
	public ResponseEntity<Page<Cliente>> clientesPage(@RequestParam(value = "page", defaultValue = "0") Integer page, 
													  @RequestParam(value = "linhasPage", defaultValue = "5")Integer linhasPage,
													  @RequestParam(value = "orderBy", defaultValue = "id")String orderBy,
													  @RequestParam(value = "direcao", defaultValue = "ASC")String direcao){
		Page<Cliente> clientes = clienteService.clientesPage(page, linhasPage, orderBy, direcao);
		return ResponseEntity.ok(clientes);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value = "Insere um cliente")
	public ResponseEntity<?> insert(@RequestBody ClienteDTO clienteDto){
		Cliente cliente = clienteService.fromDTO(clienteDto);
		cliente = clienteService.insert(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/cliente/{id}")
	@ApiOperation(value = "Atualiza um cliente passando seu ID")
	public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDto, @PathVariable Integer id){
		Cliente cliente = clienteService.fromDTO(clienteDto);
		cliente.setId(id);
		cliente = clienteService.update(cliente);
		return ResponseEntity.ok(cliente);
	}

}
