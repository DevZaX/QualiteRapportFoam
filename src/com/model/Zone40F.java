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
public class Zone40F {
	
	public Zone40F() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Alert alert;
	@Temporal(TemporalType.DATE)
	private Date date_mouvement;
	@Temporal(TemporalType.DATE)
	private Date date_sortie;
	private int qte;
	private String id_mgz;
	private String emplacement;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getId_mgz() {
		return id_mgz;
	}
	public void setId_mgz(String id_mgz) {
		this.id_mgz = id_mgz;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public Alert getAlert() {
		return alert;
	}
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	public Date getDate_mouvement() {
		return date_mouvement;
	}
	public void setDate_mouvement(Date date_mouvement) {
		this.date_mouvement = date_mouvement;
	}
	public Date getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
	
	
	

}
