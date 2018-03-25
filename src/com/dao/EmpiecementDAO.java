package com.dao;

import java.util.List;

import com.model.Empiecement;

public interface EmpiecementDAO {

	List<Empiecement> fetchAll();

	void save(Empiecement empiecement);

	Empiecement getEmpiecementByRef(String ref);

	void update(Empiecement em);

	void delete(Empiecement em);

}
							         	