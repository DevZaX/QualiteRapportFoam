package com.index;

import java.util.Date;
import com.model.Piece;

public class AlertInjectionItems {
	
	public AlertInjectionItems() {}
	
	private Long id;
	private Piece piece;
    private String defaut;
	private int nbr_pieces;
	private String client;
	private Date date_alert;
	private Date date_fin_alert;
	private String msg;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public String getDefaut() {
		return defaut;
	}
	public void setDefaut(String defaut) {
		this.defaut = defaut;
	}
	public int getNbr_pieces() {
		return nbr_pieces;
	}
	public void setNbr_pieces(int nbr_pieces) {
		this.nbr_pieces = nbr_pieces;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getDate_alert() {
		return date_alert;
	}
	public void setDate_alert(Date date_alert) {
		this.date_alert = date_alert;
	}
	public Date getDate_fin_alert() {
		return date_fin_alert;
	}
	public void setDate_fin_alert(Date date_fin_alert) {
		this.date_fin_alert = date_fin_alert;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
