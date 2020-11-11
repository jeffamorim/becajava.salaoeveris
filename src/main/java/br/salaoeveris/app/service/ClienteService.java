package br.salaoeveris.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.response.ListClienteResponse;


@Service
public class ClienteService {

	final ClienteRepository _repository;
	
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}
	
	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();	
		base.statusCode = 400;
		
		if (clienteRequest.getNome().isEmpty()) {
			
			base.message = "Nome do cliente não informado";
			return base;
 		}
		
		if (clienteRequest.getEndereco().isEmpty()) {
			base.message = "Endereço do cliente não informado";
			return base;
 		}
		
		if (clienteRequest.getTelefone().isEmpty()) {
			base.message = "Telefone do cliente não informado";
			return base;
 		}
		
		if (clienteRequest.getCpf().isEmpty()) {
			base.message = "Cpf do cliente não informado";
			return base;
 		}
		
		cliente.setNome(clienteRequest.getNome());
		cliente.setEndereco(clienteRequest.getEndereco());
		cliente.setTelefone(clienteRequest.getTelefone());
		cliente.setCpf(clienteRequest.getCpf());
		
		_repository.save(cliente);
		base.statusCode = 201;
		base.message = "Cliente cadastrado com sucesso";
		return base;
	}
	


	public ListClienteResponse listar() {
		List<Cliente> lista = _repository.findAll();
		
		List<ClienteResponse> clienteResponse = new ArrayList<ClienteResponse>();
		
		
		for(Cliente cliente : lista ) {
			ClienteResponse clienteResponseList = new ClienteResponse();
			
			clienteResponseList.setNome(cliente.getNome());
			clienteResponseList.setEndereco(cliente.getEndereco());
			clienteResponseList.setTelefone(cliente.getTelefone());
			clienteResponseList.setId(cliente.getId());
			
			clienteResponse.add(clienteResponseList);
		}
		
		ListClienteResponse response = new ListClienteResponse();
		response.setClientes(clienteResponse);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso";
		return response;
		
	}
	

	public ClienteResponse obter(Long id) {
		java.util.Optional<Cliente> cliente = _repository.findById(id);
	
				
		ClienteResponse response = new ClienteResponse();
		
		if(cliente == null) {
			response.message = "Cliente não encontrado";
			response.statusCode = 404;
			return response;
		}
		
		response.setNome(cliente.get().getNome());
		response.setTelefone (cliente.get().getTelefone());
		response.setEndereco(cliente.get().getEndereco());

		response.message = "Cliente obtido com sucesso";
		response.statusCode = 200;
		return response;

	}
	
}

	
