package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class AlertInjection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	

	
    private String defaut;
	private int nbr_pieces;
	private String client;
	@Temporal(TemporalType.DATE)
	private Date date_alert;
	@Temporal(TemporalType.DATE)
	private Date date_fin_alert;
	@Column(length =1000)
	private String msg;
	@Lob
	private byte[] picture;
	private Long projet_id;
	
	
	public Long getProjet_id() {
		return projet_id;
	}

	public void setProjet_id(Long projet_id) {
		this.projet_id = projet_id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	

	

	public String getDefaut() {
		return defaut;
	}

	public void setDefaut(String defaut) {
		this.defaut = defaut;
	}

	public int getNbr_pieces() {
		return nbr_pieces;
	}

	public void setNbr_pieces(int nbr_pieces) {
		this.nbr_pieces = nbr_pieces;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getDate_alert() {
		return date_alert;
	}

	public void setDate_alert(Date date_alert) {
		this.date_alert = date_alert;
	}

	public Date getDate_fin_alert() {
		return date_fin_alert;
	}

	public void setDate_fin_alert(Date date_fin_alert) {
		this.date_fin_alert = date_fin_alert;
	}

	
	

}
