package com.dao;

import java.util.Date;

import org.hibernate.Query;
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


	@Override
	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlMur where date between :startDate and :endDate and ref = :ref");
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    query.setParameter("ref", upperCase);
	    return (ControlMur) query.uniqueResult();
		
	}
	
	

}
