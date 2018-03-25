package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Phase;

@Repository
public class PhaseDAOImpl implements PhaseDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Phase> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Phase").list();
	}

	@Override
	public Phase find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Phase) session.load(Phase.class, new Long(id));
	}

	@Override
	public Phase findByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Phase where title=:title").setParameter("title", title);
		return (Phase)query.uniqueResult();
	}

	@Override
	public void update(Phase phase) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(phase);
	}

	@Override
	public void save(Phase phase) {
		Session session = sessionFactory.getCurrentSession();
		session.save(phase);
		
	}

	@Override
	public void delete(Phase phase) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(phase);		
	}

}
