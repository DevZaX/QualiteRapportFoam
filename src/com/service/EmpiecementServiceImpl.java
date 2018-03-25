package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmpiecementDAO;
import com.model.Empiecement;

@Service
public class EmpiecementServiceImpl implements EmpiecementService {
	
	@Autowired
	private EmpiecementDAO empiecementDAO;
	
	

	public void setEmpiecementDAO(EmpiecementDAO empiecementDAO) {
		this.empiecementDAO = empiecementDAO;
	}



	@Override
	@Transactional
	public List<Empiecement> fetchAll() {
		return empiecementDAO.fetchAll();
	}



	@Override
	@Transactional
	public void save(Empiecement empiecement) {
		
		empiecementDAO.save(empiecement);
		
	}



	@Override
	@Transactional
	public Empiecement getEmpiecementByRef(String ref) {
		
		return empiecementDAO.getEmpiecementByRef(ref);
	}



	@Override
	@Transactional
	public void update(Empiecement em) {
		empiecementDAO.update(em);
	}



	@Override
	@Transactional
	public void delete(Empiecement em) {
		empiecementDAO.delete(em);
		
	}

}
