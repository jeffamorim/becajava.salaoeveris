package br.salaoeveris.app.request;

import java.util.List;

import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.response.BaseResponse;

public class AgendamentoList extends BaseResponse{
	
	private List<Agendamento> agendamentos;

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
}
