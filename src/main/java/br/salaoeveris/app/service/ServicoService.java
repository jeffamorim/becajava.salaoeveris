  package br.salaoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.repository.ServicoRepository;
import br.salaoeveris.app.request.ServicoList;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ServicoResponse;

@Service
public class ServicoService {

	final ServicoRepository _repository;

	@Autowired
	public ServicoService(ServicoRepository repository) {
		_repository = repository;
	}
	
	public BaseResponse inserir(ServicoRequest servicoResponse) {
		Servico servico = new Servico();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;
		
		if (servicoResponse.getNome().isEmpty()) {
			base.message = "Nome do serviço não foi preenchido.";
			return base;
		}

		if (servicoResponse.getValor().isEmpty()) {
			base.message = "Valor do serviço não foi preenchido.";
			return base;
		}

		servico.setNome(servicoResponse.getNome());
		servico.setValor(servicoResponse.getValor());

		_repository.save(servico);
		base.statusCode = 201;
		base.message = "Serviço cadastrado com sucesso.";
		return base;
	}
	
	public ServicoResponse obter(Long id) {
		Optional<Servico> servico = _repository.findById(id);
		ServicoResponse response = new ServicoResponse();

		if (servico == null) {
			response.message = "Servico não encontrado";
			response.statusCode = 404;
			return response;
		}

		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());

		response.message = "Serviço obtido com sucesso";
		response.statusCode = 200;
		return response;
	}
	
	public ServicoList listar() {

		List<Servico> servico = _repository.findAll();

		ServicoList response = new ServicoList();
		response.setServicos(servico);
		response.statusCode = 200;
		response.message = "Lista de serviços obtidos com sucesso.";

		return response;
	}
}
