package com.index;

public class Scrap implements Comparable<Scrap> {

	private String critere;
	private Double scrap;
	
	
	
	public String getCritere() {
		return critere;
	}
	public void setCritere(String critere) {
		this.critere = critere;
	}
	public Double getScrap() {
		return scrap;
	}
	public void setScrap(Double scrap) {
		this.scrap = scrap;
	}
	
	@Override
	public int compareTo(Scrap o) {
		double scrap_quantity = (double) o.getScrap();
		if(this.scrap > scrap_quantity) {
			return -1;
		}
		if(this.scrap < scrap_quantity ) {
			return 1;
		}
		
		return 0;
		
		
		
	}
	
	
}
