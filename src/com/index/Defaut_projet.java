package com.index;

public class Defaut_projet implements Comparable<Defaut_projet> {
	
	private String projet;
	private int qte;
	
	public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	@Override
	public int compareTo(Defaut_projet o) {
		return o.getQte()-this.getQte();
	}
	
	
}
