package com.index;

import java.util.List;

import com.model.Defaut;
import com.model.DefautControl;

public class ControleInjectionIndex {
	
	public ControleInjectionIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String date;
	private String equipe;
	private String matricule;
	private String prototype;
	private int qteAccepter;
	private int qteController;
	private int qteRejeter;
	private int qteRetoucher;
	private String ref;
	private String shift;
	private String zone;
	private String defaut;
	private String version;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPrototype() {
		return prototype;
	}
	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}
	public int getQteAccepter() {
		return qteAccepter;
	}
	public void setQteAccepter(int qteAccepter) {
		this.qteAccepter = qteAccepter;
	}
	public int getQteController() {
		return qteController;
	}
	public void setQteController(int qteController) {
		this.qteController = qteController;
	}
	public int getQteRejeter() {
		return qteRejeter;
	}
	public void setQteRejeter(int qteRejeter) {
		this.qteRejeter = qteRejeter;
	}
	public int getQteRetoucher() {
		return qteRetoucher;
	}
	public void setQteRetoucher(int qteRetoucher) {
		this.qteRetoucher = qteRetoucher;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	
	public String getDefaut() {
		return defaut;
	}
	public void setDefaut(String defaut) {
		this.defaut = defaut;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	

}
