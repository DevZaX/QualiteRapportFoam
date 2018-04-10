package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Famille {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;
	private Double weight;
	private Double price;
	private String title;
	
	@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Piece> pieces = new ArrayList<>();
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Projet projet;
	
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Famille(Long id_famille, Double weight, Double price) {
		super();
		this.id = id_famille;
		this.weight = weight;
		this.price = price;
	}

	public Famille() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id_famille) {
		this.id= id_famille;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

	


}
