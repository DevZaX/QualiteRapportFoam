package com.service;

import java.util.List;

import com.model.Empiecement;

public interface EmpiecementService {

	public List<Empiecement> fetchAll();

	public void save(Empiecement empiecement);

	public Empiecement getEmpiecementByRef(String ref);

	public void update(Empiecement em);

	public void delete(Empiecement em);

}
