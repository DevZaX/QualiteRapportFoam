package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Zone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id_zone) {
		this.id = id_zone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Zone(Long id_zone, String title) {
		super();
		this.id = id_zone;
		this.title = title;
	}

	public Zone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
