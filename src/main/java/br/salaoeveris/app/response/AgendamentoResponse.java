package br.salaoeveris.app.response;

import java.time.LocalDateTime;

public class AgendamentoResponse extends BaseResponse {
	private Long id;
	private LocalDateTime dataHora;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
	
	
	

}
