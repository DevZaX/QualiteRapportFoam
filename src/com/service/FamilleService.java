package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Famille;

@Service
public interface FamilleService {
	
  public void save(Famille famille);
  public void update(Famille famille);
  public Famille getFamilleByTitle(String title);
  public List<Famille> fetchAll();

}
