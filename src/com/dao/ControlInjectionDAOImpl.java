package com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ControlInjection;

@Repository
public class ControlInjectionDAOImpl implements ControlInjectionDAO {

    private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void addControlInjection(ControlInjection controlInjection) {
		Session session = sessionFactory.getCurrentSession();
		session.save(controlInjection);
	}


	@Override
	public List<ControlInjection> fetchAll(Date startDate, Date endDate) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlInjection where date between :startDate and :endDate");
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    return query.list();
	}


	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		ControlInjection controlInjection = (ControlInjection) session.load(ControlInjection.class, new Long(id));
		
		if(controlInjection != null)
		{
			session.delete(controlInjection);
		}
		
	}


	@Override
	public ControlInjection fetchAll(Date startDate, Date endDate, String ref) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlInjection where date between :startDate and :endDate and ref = :ref");
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    query.setParameter("ref", ref);
	    return (ControlInjection) query.uniqueResult();
	}


	@Override
	public ControlInjection findByRef(String string) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlInjection where ref = :ref");
	    query.setParameter("ref", string);
	    return (ControlInjection) query.uniqueResult();
		
	}
	
	

}
