package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Zone40F;

@Repository
public class Zone40FDAOImpl implements Zone40FDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(Zone40F zone40f) {
		Session session = sessionFactory.getCurrentSession();
		session.save(zone40f);
		
	}



	@Override
	public void update(Zone40F zone40f) {
		Session session = sessionFactory.getCurrentSession();
		session.update(zone40f);
		
	}



	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Zone40F zone40f = (Zone40F) session.load(Zone40F.class, new Long(id));
		session.delete(zone40f);
		
	}



	@Override
	public List<Zone40F> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Zone40F order by id desc").list();
	}



	@Override
	public Zone40F find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Zone40F) session.load(Zone40F.class, new Long(id));
	}

}
