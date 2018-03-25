package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Alert;
import com.model.ControlReception;

@Repository
public class ControlReceptionDAOImpl implements ControlReceptionDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(ControlReception controlReception) {
		Session session = sessionFactory.getCurrentSession();
		session.save(controlReception);
		
	}



	@Override
	public List<ControlReception> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from ControlReception").list();
	}



	@Override
	public ControlReception find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (ControlReception) session.load(ControlReception.class, new Long(id));
	}



	@Override
	public Alert getAlert(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Alert where controlReception_id = :id");
		query.setParameter("id", id);
		return (Alert) query.uniqueResult();
	}



	@Override
	public void delete(Long num) {
		Session session = sessionFactory.getCurrentSession();
		ControlReception controlReception = find(num);
		session.delete(controlReception);
		
	}

}
