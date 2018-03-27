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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class ControlMur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    

    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<DefautControlMur> defautControlMurs = new ArrayList<>();
	
	
    @Temporal(TemporalType.DATE)
    private Date date;
    private String matricule;
    private String ref;
   
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

	
	
	public List<DefautControlMur> getDefautControlMurs() {
		return defautControlMurs;
	}
	public void setDefautControlMurs(List<DefautControlMur> defautControlMurs) {
		this.defautControlMurs = defautControlMurs;
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
