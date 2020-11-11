package br.salaoeveris.app.response;

import java.util.List;

import br.salaoeveris.app.model.Cliente;

public class ListClienteResponse extends BaseResponse {
	private List<ClienteResponse> Clientes;
	

	public List<ClienteResponse> getClientes() {
		return Clientes;
	}

	public void setClientes(List<ClienteResponse> clientes) {
		Clientes = clientes;
	}

}

