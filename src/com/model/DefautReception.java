package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DefautReception {
	
	private String title;
	
	@Id
	private String code ;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public DefautReception() {}

}
