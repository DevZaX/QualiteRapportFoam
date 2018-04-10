package com.wrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Piece;

public class AlertInjectionWrapper {
	
	private List<Long> id = new ArrayList<>();
	private String defaut;
	private int nbr_pieces;
	private String client;
	private String date_alert;
	private String date_fin_alert;
	private String msg;
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public List<Long> getId() {
		return id;
	}
	public void setId(List<Long> id) {
		this.id = id;
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
	public String getDate_alert() {
		return date_alert;
	}
	public void setDate_alert(String date_alert) {
		this.date_alert = date_alert;
	}
	public String getDate_fin_alert() {
		return date_fin_alert;
	}
	public void setDate_fin_alert(String date_fin_alert) {
		this.date_fin_alert = date_fin_alert;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
