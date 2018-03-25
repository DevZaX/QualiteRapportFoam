package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Emballage;

@Repository
public class EmballageDAOImpl implements EmballageDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(Emballage emballage) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(emballage);
	}

}
