package com.index;

import java.util.ArrayList;
import java.util.List;

import com.model.DefautControlReception;

public class ControlRIndex {
	
	
	//date ctrl + num + ref + version + num lot + qte planf + qte ctrl + qte acce + qta rej + defaut + detaille defaut + fourni + controleur
	
	public ControlRIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Long numero_control;
	
	public Long getNumero_control() {
		return numero_control;
	}
	public void setNumero_control(Long numero_control) {
		this.numero_control = numero_control;
	}
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	private String ref;
	private String numLot;
	private String date_reception;
	private String date_production;
    private int qte_planned;
	private int qte_controlled;
	private int qte_accepter;
	private int qte_nonOK;
	private String username;
	private Long alert_etat;
	
	
	public Long getAlert_etat() {
		return alert_etat;
	}
	public void setAlert_etat(Long long1) {
		this.alert_etat = long1;
	}
	private String fournisseur;
	
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	private String version;
	
	public int getQte_accepter() {
		return qte_accepter;
	}
	public void setQte_accepter(int qte_accepter) {
		this.qte_accepter = qte_accepter;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	private String date_creation;
	
	private List<DefautControlReception> defautControlReceptions = new ArrayList<>();
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getNumLot() {
		return numLot;
	}
	public void setNumLot(String numLot) {
		this.numLot = numLot;
	}
	public String getDate_reception() {
		return date_reception;
	}
	public void setDate_reception(String date_reception) {
		this.date_reception = date_reception;
	}
	public String getDate_production() {
		return date_production;
	}
	public void setDate_production(String date_production) {
		this.date_production = date_production;
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
	
	public int getQte_nonOK() {
		return qte_nonOK;
	}
	public void setQte_nonOK(int qte_nonOK) {
		this.qte_nonOK = qte_nonOK;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<DefautControlReception> getDefautControlReceptions() {
		return defautControlReceptions;
	}
	public void setDefautControlReceptions(List<DefautControlReception> defautControlReceptions) {
		this.defautControlReceptions = defautControlReceptions;
	}
	
	
	

}
