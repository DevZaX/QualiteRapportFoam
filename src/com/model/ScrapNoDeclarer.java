package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class ScrapNoDeclarer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String shift;
	private String equipe;
	private String ref;
	private int qte_scrape;
	private int qte;
	
	@Length(max=1000)
	private String raison_scrap;
	
	private String zone;
	

}
