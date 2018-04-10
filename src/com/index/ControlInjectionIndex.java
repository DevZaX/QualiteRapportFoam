package com.index;

public class ControlInjectionIndex {

	private String ref;
	private int qteScrap;
	private int qteRetouche1;
	private int qteRetouche2;
	private int qteOK;
	private int qteController;
	private float scrapRate;
	private double IPPM;
	private double scrapCost;
	private double scrapTotalCost;
	private double PCCostScrap;
	private double PCCostTotal;
	private double PCWScrap;
	private double PCWTotal;
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
	
	
	public int getQteScrap() {
		return qteScrap;
	}
	public void setQteScrap(int qteScrap) {
		this.qteScrap = qteScrap;
	}
	public int getQteRetouche1() {
		return qteRetouche1;
	}
	public void setQteRetouche1(int qteRetouche1) {
		this.qteRetouche1 = qteRetouche1;
	}
	public int getQteRetouche2() {
		return qteRetouche2;
	}
	public void setQteRetouche2(int qteRetouche2) {
		this.qteRetouche2 = qteRetouche2;
	}
	public int getQteOK() {
		return qteOK;
	}
	public void setQteOK(int qteOK) {
		this.qteOK = qteOK;
	}
	public int getQteController() {
		return qteController;
	}
	public void setQteController(int qteController) {
		this.qteController = qteController;
	}
	public double getScrapRate() {
		return scrapRate;
	}
	public void setScrapRate(float scrapRate) {
		this.scrapRate = scrapRate;
	}
	public double getIPPM() {
		return IPPM;
	}
	public void setIPPM(double iPPM) {
		IPPM = iPPM;
	}
	public double getScrapCost() {
		return scrapCost;
	}
	public void setScrapCost(double scrapCost) {
		this.scrapCost = scrapCost;
	}
	public double getScrapTotalCost() {
		return scrapTotalCost;
	}
	public void setScrapTotalCost(double scrapTotalCost) {
		this.scrapTotalCost = scrapTotalCost;
	}
	public double getPCCostScrap() {
		return PCCostScrap;
	}
	public void setPCCostScrap(double pCCostScrap) {
		PCCostScrap = pCCostScrap;
	}
	public double getPCCostTotal() {
		return PCCostTotal;
	}
	public void setPCCostTotal(double pCCostTotal) {
		PCCostTotal = pCCostTotal;
	}
	public double getPCWScrap() {
		return PCWScrap;
	}
	public void setPCWScrap(double pCWScrap) {
		PCWScrap = pCWScrap;
	}
	public double getPCWTotal() {
		return PCWTotal;
	}
	public void setPCWTotal(double pCWTotal) {
		PCWTotal = pCWTotal;
	}

	@Override
	public String toString() {
		return "ControlInjectionIndex [ref=" + ref + ", qteScrap=" + qteScrap + ", qteRetouche1=" + qteRetouche1
				+ ", qteRetouche2=" + qteRetouche2 + ", qteOK=" + qteOK + ", qteController=" + qteController
				+ ", scrapRate=" + scrapRate + ", IPPM=" + IPPM + ", scrapCost=" + scrapCost + ", scrapTotalCost="
				+ scrapTotalCost + ", PCCostScrap=" + PCCostScrap + ", PCCostTotal=" + PCCostTotal + ", PCWScrap="
				+ PCWScrap + ", PCWTotal=" + PCWTotal + "]";
	}

}
