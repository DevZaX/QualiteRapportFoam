package com.wrapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProjetWrapper {
	
	private String title;
	private String famille;
	private String ref;
	private String version;
	private List<MultipartFile> images;
	private List<String> posts = new ArrayList<>();
	private String prototype;


	public List<String> getPosts() {
		return posts;
	}

	public void setPosts(List<String> posts) {
		this.posts = posts;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public ProjetWrapper() {	
	}

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

	public String getPrototype() {
		return prototype;
	}

	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}

	
	

}
