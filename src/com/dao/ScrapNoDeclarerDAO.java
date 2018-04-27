package com.dao;

import java.util.List;

import com.model.ScrapNoDeclarer;

public interface ScrapNoDeclarerDAO {

	void save(ScrapNoDeclarer scrapNoDeclarer);

	void delete(ScrapNoDeclarer scrapNoDeclarer);

	List<ScrapNoDeclarer> fetchAll();

	List<ScrapNoDeclarer> filter(String shift, String equipe, String zone, String ref);

}
