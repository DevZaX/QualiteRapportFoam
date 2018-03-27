package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class ControlReception {
	
	public ControlReception() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date date_creation;
    
	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	@OneToOne(cascade=CascadeType.ALL)
	private Emballage emballage;
	
	private int qte_planned;
	
	private int qte_controlled;
	
	private int qte_nonConfortable;
	
	@OneToMany(mappedBy="controlReception",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER,orphanRemoval=true)
	private List<DefautControlReception> defautControlReceptions = new ArrayList<>();
	
	private String username;

	public Emballage getEmballage() {
		return emballage;
	}

	public void setEmballage(Emballage emballage) {
		this.emballage = emballage;
	}

	public int getQte_planned() {
		return qte_planned;
	}

	public void setQte_planned(int qte_planned) {
		this.qte_planned = qte_planned;
	}

	public int getQte_controlled() {
		return qte_controlled;
	}

	public void setQte_controlled(int qte_controlled) {
		this.qte_controlled = qte_controlled;
	}

	public int getQte_nonConfortable() {
		return qte_nonConfortable;
	}

	public void setQte_nonConfortable(int qte_nonConfortable) {
		this.qte_nonConfortable = qte_nonConfortable;
	}

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DefautControlReception> getDefautControlReceptions() {
		return defautControlReceptions;
	}

	public void setDefautControlReceptions(List<DefautControlReception> defautControlReceptions) {
		this.defautControlReceptions = defautControlReceptions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
