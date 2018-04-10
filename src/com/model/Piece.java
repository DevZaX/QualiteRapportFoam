package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Proxy(lazy=false)
public class Piece {
	
	@Id
	private String ref;
	private String version;
	private Double price;
	
	@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<PosteForPiece>  posteForPieces = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Picture> images = new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Famille famille;
	
	
	
	
	public List<PosteForPiece> getPosteForPieces() {
		return posteForPieces;
	}

	public void setPosteForPieces(List<PosteForPiece> posteForPieces) {
		this.posteForPieces = posteForPieces;
	}

	
	
	

	
	
	
	public List<Picture> getImages() {
		return images;
	}

	public void setImages(List<Picture> images) {
		this.images = images;
	}

	
	
	

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
