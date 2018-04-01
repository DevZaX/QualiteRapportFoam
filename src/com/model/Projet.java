package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Proxy(lazy=false)
@Entity
public class Projet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Famille> familles = new ArrayList<>();
	
	private String title;

	
	
	
	

	
	public void setFamilles(List<Famille> familles) {
		this.familles = familles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id_projet) {
		this.id = id_projet;
	}

	public List getFamilles() {
		return familles;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Projet(Long id_projet, List familles, String title) {
		super();
		this.id = id_projet;
		this.familles = familles;
		this.title = title;
	}

	public Projet() {
		super();
		
	}
	
	
	

}
