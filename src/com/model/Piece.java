package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Piece {
	
	@Id
	private String ref;
	
	private String version;
	
	private Double price;
	
	private int etat;
	
	
	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	private Famille famille;
	
	

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Piece(String ref, String version, Famille famille) {
		super();
		this.ref = ref;
		this.version = version;
		this.famille = famille;
	}

	public Piece() {
		super();
		
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	

}
