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
	
	public BaseResponse inserir(AgendamentoRequest agendamentoResponse) {
		Cliente cliente = new Cliente();
		Servico servico = new Servico();
		Agendamento agendamento = new Agendamento();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;

		if (agendamentoResponse.getDataHora().equals(null)) {
			base.message = "A data e hora do serviço não foi preenchido.";
			return base;
		}

		if (agendamento.getClienteId() == null ) {
			base.message = "Cliente não inserido.";
			return base;
		}
		
		if (agendamento.getServicoId() == null ) {
			base.message = "servico não inserido.";
			return base;
		}


		agendamento.setDataHora(agendamentoResponse.getDataHora());
		agendamento.setClienteId(cliente);
		agendamento.setServicoId(servico);


		_repository.save(agendamento);
		base.statusCode = 201;
		base.message = "Agendamento inserido com sucesso.";
		return base;
	}
}
