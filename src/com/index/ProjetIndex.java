package com.index;

public class ProjetIndex {

	private String title;
	private String famille;
	private String ref;
	private String version;
	private double weight;
	private double price;
	private double priceAPPT;
	private Long id;
	
	public ProjetIndex() {}

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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceAPPT() {
		return priceAPPT;
	}

	public void setPriceAPPT(double priceAPPT) {
		this.priceAPPT = priceAPPT;
	}

	public void setId(Long id) {
		this.id  = id;;
		
	}

	public Long getId() {
		return id;
	}
	
	
}