package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ControlInjection;
import com.model.ControlMur;

@Repository
public class ControlMurDAOImpl implements ControlMurDAO {

    private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void addControlMur(ControlMur controlMur) {
		Session session = sessionFactory.getCurrentSession();
		session.save(controlMur);
	}
	
	

}
