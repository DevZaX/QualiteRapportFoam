package com.wrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControlReceptionWrapper {
	
    private String ref;
	
	private String numLot;
	
	private String date_reception;
	
	private String date_production;
	
    private int qte_planned;
	
	private int qte_controlled;
	
	private int qte_nonConfortable;
	
	private String date_creation;
	
	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}

	private List<String> defauts = new ArrayList<>();
	
	public ControlReceptionWrapper() {}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNumLot() {
		return numLot;
	}

	public void setNumLot(String numLot) {
		this.numLot = numLot;
	}

	
	public String getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(String date_reception) {
		this.date_reception = date_reception;
	}

	public String getDate_production() {
		return date_production;
	}

	public void setDate_production(String date_production) {
		this.date_production = date_production;
	}

	public int getQte_planned() {
		return qte_planned;
	}

	public void setQte_planned(int qte_planned) {
		this.qte_planned = qte_planned;
	}

	public int getQte_controlled() {
		return qte_controlled;
	}

	public void setQte_controlled(int qte_controlled) {
		this.qte_controlled = qte_controlled;
	}

	public int getQte_nonConfortable() {
		return qte_nonConfortable;
	}

	public void setQte_nonConfortable(int qte_nonConfortable) {
		this.qte_nonConfortable = qte_nonConfortable;
	}

	public List<String> getDefauts() {
		return defauts;
	}

	public void setDefauts(List<String> defauts) {
		this.defauts = defauts;
	}
	
	
	
	

}
