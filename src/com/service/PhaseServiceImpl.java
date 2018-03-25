package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PhaseDAO;
import com.model.Phase;

@Service
public class PhaseServiceImpl implements PhaseService {
	
	private PhaseDAO phaseDAO;
	
	
    @Autowired
	public void setPhaseDAO(PhaseDAO phaseDAO) {
		this.phaseDAO = phaseDAO;
	}

	@Override
	@Transactional
	public List<Phase> fetchAll() {
		return phaseDAO.fetchAll();
	}

	@Override
	@Transactional
	public Phase find(Long id) {
	return phaseDAO.find(id);
	}

	@Override
	@Transactional
	public Phase findByTitle(String title) {
		return phaseDAO.findByTitle(title);
	}

	@Override
	@Transactional
	public void update(Phase phase) {
		phaseDAO.update(phase);
		
	}

	@Override
	@Transactional
	public void save(Phase phase) {
		phaseDAO.save(phase);
		
	}

	@Override
	@Transactional
	public void delete(Phase phase) {
		phaseDAO.delete(phase);
		
	}

}
