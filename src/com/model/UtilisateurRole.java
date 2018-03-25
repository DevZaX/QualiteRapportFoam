package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class UtilisateurRole {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_user_role;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Utilisateur utilisateur;
	
	
	private String role;
	
	


	public UtilisateurRole() {
		super();
	}


	public UtilisateurRole(Long id_user_role, Utilisateur utilisateur, String role) {
		super();
		this.id_user_role = id_user_role;
		this.utilisateur = utilisateur;
		this.role = role;
	}


	public Long getId_user_role() {
		return id_user_role;
	}


	public void setId_user_role(Long id_user_role) {
		this.id_user_role = id_user_role;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	
	
	
	

}
