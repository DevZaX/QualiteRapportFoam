package com.index;

public class ScrapProjet implements Comparable<ScrapProjet> {

	private String projet;
	private Double scrap;
	
	
	public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	public Double getScrap() {
		return scrap;
	}
	public void setScrap(Double scrap) {
		this.scrap = scrap;
	}
	
	@Override
	public int compareTo(ScrapProjet o) {
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
