package br.salaoeveris.app.request;

import java.sql.Date;

import org.hibernate.type.LocalDateTimeType;

public class AgendamentoRequest {
	private Date dataHora;

	private Long clienteId;
	private Long servicoId;
	
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getServicoId() {
		return servicoId;
	}
	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}



	
}
