package com.service;

import java.util.List;

import com.model.ScrapNoDeclarer;



public interface ScrapNoDeclarerService {
	
	public void save(ScrapNoDeclarer scrapNoDeclarer);
	public void delete(ScrapNoDeclarer scrapNoDeclarer);
	public List<ScrapNoDeclarer> fetchAll();
	public List<ScrapNoDeclarer> filter(String shift,String equipe,String zone,String ref);

}
