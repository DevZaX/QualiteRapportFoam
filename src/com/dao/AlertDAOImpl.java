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
public class AlertDAOImpl implements AlertDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(Alert alert) {
		Session session = sessionFactory.getCurrentSession();
		session.save(alert);
	}



	@Override
	public ControlReception getControlReception(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlReception where controlReception_id = :id");
		query.setParameter("id", id);
		return (ControlReception) query.uniqueResult();
	}



	@Override
	public Alert find(Long num) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Alert where numero = :num ");
		query.setParameter("num", num);
		return (Alert) query.uniqueResult();
	}



	@Override
	public void update(Alert alert) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(alert);
		
	}



	@Override
	public List<Alert> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Alert> alerts = session.createQuery("from Alert").list();
		return alerts;
	}



	@Override
	public void delete(Long num) {
		Session session = sessionFactory.getCurrentSession();
		Alert alert = find(num);
		if(alert != null)
		{
			session.delete(alert);
		}
		
	}



	@Override
	public List<Alert> fetchAllOpen() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Alert where status='open'").list();
	}

}
