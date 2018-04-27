package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ScrapNoDeclarerDAO;
import com.model.ScrapNoDeclarer;

public class ScrapNoDeclarerServiceImpl implements ScrapNoDeclarerService {
	
	private ScrapNoDeclarerDAO scrapNoDeclarerDAO;

	@Override
	public void save(ScrapNoDeclarer scrapNoDeclarer) {
		scrapNoDeclarerDAO.save(scrapNoDeclarer);
	}

	@Override
	public void delete(ScrapNoDeclarer scrapNoDeclarer) {
		scrapNoDeclarerDAO.delete(scrapNoDeclarer);
		
	}

	@Override
	public List<ScrapNoDeclarer> fetchAll() {
		return scrapNoDeclarerDAO.fetchAll();
	}

	@Override
	public List<ScrapNoDeclarer> filter(String shift, String equipe, String zone, String ref) {
		return scrapNoDeclarerDAO.filter(shift,equipe,zone,ref);
	}

	@Autowired
	public void setScrapNoDeclarerDAO(ScrapNoDeclarerDAO scrapNoDeclarerDAO) {
		this.scrapNoDeclarerDAO = scrapNoDeclarerDAO;
	}

}
