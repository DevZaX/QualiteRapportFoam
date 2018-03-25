package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;




@Entity
@Proxy(lazy=false)
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_user;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<UtilisateurRole> utilisateurRoles = new ArrayList<UtilisateurRole>();
	
	
	private String username;
	
	private String password;
	
	private String indice;
	
	private String langue;
	

	
	public String getLangue() {
		return langue;
	}






	public void setLangue(String langue) {
		this.langue = langue;
	}






	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public Long getId_user() {
		return id_user;
	}





	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}





	public List<UtilisateurRole> getUtilisateurRoles() {
		return utilisateurRoles;
	}





	public void setUtilisateurRoles(List<UtilisateurRole> utilisateurRoles) {
		this.utilisateurRoles = utilisateurRoles;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}






	public String getIndice() {
		return indice;
	}






	public void setIndice(String indice) {
		this.indice = indice;
	}





	
	

}
