package com.index;

public class Defaut implements Comparable<Defaut> {
	
	private String defaut;
	private int qte;
	
	public String getDefaut() {
		return defaut;
	}
	public void setDefaut(String defaut) {
		this.defaut = defaut;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	@Override
	public int compareTo(Defaut o) {
		return o.getQte()-this.getQte();
	}
	@Override
	public String toString() {
		return "Defaut [defaut=" + defaut + ", qte=" + qte + "]";
	}
	
	
	

}
