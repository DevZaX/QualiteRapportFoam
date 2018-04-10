package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import com.dao.DefautDAO;

@Entity
public class Defaut {
	
	
	@Id
	private String code;
	
	private String title;
	


    private String side;

	


	public String getSide() {
		return side;
	}


	public void setSide(String side) {
		this.side = side;
	}


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


	public Defaut(String code, String title) {
		super();
		this.code = code;
		this.title = title;
	}
	
	
	public Defaut() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
