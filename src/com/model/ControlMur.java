package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ControlMur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    

    @OneToOne
	private Defaut defautControlMur;
	
	
    
    private Date date;
    private String matricule;
    private String ref;
    private int qteControle;
    private int qteAccepter;
    private int qteRetouche;
    private int qteRejete;
    private int tauxDefaut;
    private String shift;
    private String zone;
    private String prototype;
    private String equipe;
    private String matriculeControlleurInjection;
    
    
	
	public ControlMur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public Defaut getDefautControlMur() {
		return defautControlMur;
	}
	public void setDefautControlMur(Defaut defautControlMur) {
		this.defautControlMur = defautControlMur;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public int getQteControle() {
		return qteControle;
	}
	public void setQteControle(int qteControle) {
		this.qteControle = qteControle;
	}
	public int getQteAccepter() {
		return qteAccepter;
	}
	public void setQteAccepter(int qteAccepter) {
		this.qteAccepter = qteAccepter;
	}
	public int getQteRetouche() {
		return qteRetouche;
	}
	public void setQteRetouche(int qteRetouche) {
		this.qteRetouche = qteRetouche;
	}
	public int getQteRejete() {
		return qteRejete;
	}
	public void setQteRejete(int qteRejete) {
		this.qteRejete = qteRejete;
	}
	public int getTauxDefaut() {
		return tauxDefaut;
	}
	public void setTauxDefaut(int tauxDefaut) {
		this.tauxDefaut = tauxDefaut;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getPrototype() {
		return prototype;
	}
	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public String getMatriculeControlleurInjection() {
		return matriculeControlleurInjection;
	}
	public void setMatriculeControlleurInjection(String matriculeControlleurInjection) {
		this.matriculeControlleurInjection = matriculeControlleurInjection;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
	
    
    
    

}
