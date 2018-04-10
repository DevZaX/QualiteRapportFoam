package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.AlertInjection;


@Repository
public class AlertInjectionDAOImpl implements AlertInjectionDAO {
	
	 private SessionFactory sessionFactory;
		
		
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		

	@Override
	public void save(AlertInjection alertInjection) {
		Session session = sessionFactory.getCurrentSession();
		session.save(alertInjection);
		
	}

	@Override
	public void update(AlertInjection alertInjection) {
		Session session = sessionFactory.getCurrentSession();
		session.update(alertInjection);
		
	}

	@Override
	public void delete(AlertInjection alertInjection) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(alertInjection);
		
	}

	@Override
	public AlertInjection find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (AlertInjection) session.load(AlertInjection.class,new Long(id));
	}

	@Override
	public List<AlertInjection> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from AlertInjection order by id desc").list();
	} 


	@Override
	public AlertInjection findByProjet(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AlertInjection where projet_id=:id");
		query.setParameter("id", id);
		return (AlertInjection) query.uniqueResult();
	}


	
	


	

}
