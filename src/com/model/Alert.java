package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alert {
	
	public Alert() {}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ControlReception controlReception;
	
    @Temporal(TemporalType.DATE)
	private Date date_creation;
	
	private String status;
	
	
	private String phase;
	
	private Double chargeback;
	
	@Temporal(TemporalType.DATE)
	private Date date_close;
	
	private String type;

	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public ControlReception getControlReception() {
		return controlReception;
	}

	public void setControlReception(ControlReception controlReception) {
		this.controlReception = controlReception;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public Double getChargeback() {
		return chargeback;
	}

	public void setChargeback(Double chargeback) {
		this.chargeback = chargeback;
	}

	public Date getDate_close() {
		return date_close;
	}

	public void setDate_close(Date date_close) {
		this.date_close = date_close;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
