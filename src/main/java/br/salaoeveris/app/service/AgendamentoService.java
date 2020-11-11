package br.salaoeveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.repository.AgendamentoRepository;
import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;

@Service
public class AgendamentoService {
	final AgendamentoRepository _repository;

	@Autowired
	public AgendamentoService(AgendamentoRepository repository) {
		_repository = repository;
	}
	
	public BaseResponse inserir(AgendamentoRequest agendamentoRequest) {
		Cliente cliente = new Cliente();
		Servico servico = new Servico();
		Agendamento agendamento = new Agendamento();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (agendamentoRequest.getDataHora().equals(null)) {
			response.message = "A data e hora do serviço não foi preenchido.";
			return response;
		}

		if (agendamentoRequest.getClienteId() == null ) {
			response.message = "Cliente não inserido.";
			return response;
		}
		
		if (agendamentoRequest.getServicoId() == null ) {
			response.message = "servico não inserido.";
			return response;
		}
		
		cliente.setId(agendamentoRequest.getClienteId());
		agendamento.setClienteId(cliente);
		
		
		servico.setId(agendamentoRequest.getServicoId());
		agendamento.setServicoId(servico);


		_repository.save(agendamento);
		response.statusCode = 201;
		response.message = "Agendamento inserido com sucesso.";
		return response;
	}
}
