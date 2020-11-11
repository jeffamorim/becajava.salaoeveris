package br.salaoeveris.app.request;

import java.sql.Date;

import org.hibernate.type.LocalDateTimeType;

public class AgendamentoRequest {
	private Date dataHora;

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
}
