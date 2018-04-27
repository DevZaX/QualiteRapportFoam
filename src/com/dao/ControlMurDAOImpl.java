package com.dao;

import java.util.Date;
import java.util.List;

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
	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase,String mat) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlMur where date between :startDate and :endDate and ref = :ref and matricule=:mat");
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    query.setParameter("ref", upperCase);
	    query.setParameter("mat", mat);
	    return (ControlMur) query.uniqueResult();
		
	}


	@Override
	public List<ControlMur> filter(Date start, Date end, String zone, String prototype, String equipe) {
		Session session = sessionFactory.getCurrentSession();
		String requete="from ControlMur where date between :date_debut and :date_fin";
		if(!zone.equals("All")) requete = requete + " and  zone = '" + zone + "'";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut", start);
		query.setParameter("date_fin",end);
		return query.list();
	}


	@Override
	public int getInt(String requete) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
