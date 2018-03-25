package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emballage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Empiecement empiecement;
	
	private String numLot;
	
	@Temporal(TemporalType.DATE)
	private Date date_reception;
	
	@Temporal(TemporalType.DATE)
	private Date date_production;
	
	public Emballage() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empiecement getEmpiecement() {
		return empiecement;
	}

	public void setEmpiecement(Empiecement empiecement) {
		this.empiecement = empiecement;
	}

	public String getNumLot() {
		return numLot;
	}

	public void setNumLot(String numLot) {
		this.numLot = numLot;
	}

	public Date getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(Date date_reception) {
		this.date_reception = date_reception;
	}

	public Date getDate_production() {
		return date_production;
	}

	public void setDate_production(Date date_production) {
		this.date_production = date_production;
	}
	
	

}
