package com.wrapper;

import java.math.BigDecimal;

public class ProjetWrapper {
	
	private String title;
	private String famille;
	private String ref;
	private String version;
	
	private Double weight;
	private Double price;
	private Double priceAPPT;
	
	public ProjetWrapper() {	
	}

	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
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

	public Double getPriceAPPT() {
		return priceAPPT;
	}

	public void setPriceAPPT(Double priceAPPT) {
		this.priceAPPT = priceAPPT;
	}
	
	

}
