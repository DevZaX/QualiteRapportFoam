package com.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.ScrapNoDeclarer;

public class ScrapNoDeclarerDAOImpl implements ScrapNoDeclarerDAO{
	
	private SessionFactory sessionFactory;

	@Override
	public void save(ScrapNoDeclarer scrapNoDeclarer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(scrapNoDeclarer);
		
	}

	@Override
	public void delete(ScrapNoDeclarer scrapNoDeclarer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(scrapNoDeclarer);
		
	}

	@Override
	public List<ScrapNoDeclarer> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from ScrapNoDeclarer").list();
	}

	@Override
	public List<ScrapNoDeclarer> filter(String shift, String equipe, String zone, String ref) {
		Session session = sessionFactory.getCurrentSession();
		String requete = "from ScrapNoDeclarer where date between :date1 and :date2";
		if("All".equals(shift)) requete = requete + " and shift=:shift";
		if("All".equals(equipe)) requete = requete + " and equipe=:equipe";
		if("All".equals(zone)) requete = requete + " and zone=:zone";
		if("All".equals(ref)) requete = requete + " and ref=:ref";
		System.err.println("### scrap no declarer ###"+requete);
		Query query = session.createQuery(requete);
		query.setParameter("shift", shift);
		query.setParameter("equipe", equipe);
		query.setParameter("zone", zone);
		query.setParameter("ref", ref);
		query.setParameter("date1",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		query.setParameter("date2",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return session.createQuery(requete).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
