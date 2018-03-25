package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Empiecement;

@Repository
public class EmpiecementDAOImpl implements EmpiecementDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List<Empiecement> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Empiecement> empiecements = session.createQuery("from Empiecement").list();
		return empiecements;
	}



	@Override
	public void save(Empiecement empiecement) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empiecement);
	}



	@Override
	public Empiecement getEmpiecementByRef(String ref) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Empiecement where ref=:ref");
		query.setParameter("ref", ref);
		return (Empiecement) query.uniqueResult();
	}



	@Override
	public void update(Empiecement em) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(em);
		
	}



	@Override
	public void delete(Empiecement em) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(em);
		
	}

}
