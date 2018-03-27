package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class DefautControlMur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	
	
	private String code;
	
	private String title;
	
	private String type;
	
	private int qte;


	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@ManyToOne(cascade=CascadeType.ALL)
	private ControlMur control;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ControlMur getControl() {
		return control;
	}

	public void setControl(ControlMur control) {
		this.control = control;
	}

	public DefautControlMur(String code, String title, ControlMur control) {
		super();
		this.code = code;
		this.title = title;
		this.control = control;
	}

	public DefautControlMur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}