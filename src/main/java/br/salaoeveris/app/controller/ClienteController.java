package br.salaoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.response.ListClienteResponse;
import br.salaoeveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController{
	
	final ClienteService _service;
	
	@Autowired
	public ClienteController(ClienteService service) {
		_service = service;
	}
	
	@PostMapping(path = "/inserir")
	public ResponseEntity inserir(@RequestBody ClienteRequest clienteRequest) {
		try {
			BaseResponse response = _service.inserir(clienteRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		}catch(Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	
	@GetMapping(path = "/listar")
	public ResponseEntity listar() {
		try {
			ListClienteResponse clientes = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		}catch(Exception e){
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@GetMapping(path = "/{id}")
    public ResponseEntity obter(@PathVariable Long id) {		
		try {
			ClienteResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);	
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}   	
    }
}
