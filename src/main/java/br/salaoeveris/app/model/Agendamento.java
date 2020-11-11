package br.salaoeveris.app.model;

import java.sql.Date;
import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataHora;
	
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente clienteId;
	
	@ManyToOne
	@JoinColumn(name = "servicoId")
	private Servico servicoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public Servico getServicoId() {
		return servicoId;
	}

	public void setServicoId(Servico servicoId) {
		this.servicoId = servicoId;
	}
	

	
	
	
}
