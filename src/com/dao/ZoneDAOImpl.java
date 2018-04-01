package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Zone;

@Repository
public class ZoneDAOImpl implements ZoneDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void addZone(Zone zone) {
		Session session = sessionFactory.getCurrentSession();
		session.save(zone);
	}



	@Override
	public List<Zone> listZone() {
		Session session = sessionFactory.getCurrentSession();
		List<Zone> zones = new ArrayList<>();
		zones = session.createQuery("from Zone order By id DESC").list();
		return zones;
	}



	@Override
	public Zone getZoneById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Zone zone = (Zone) session.load(Zone.class, new Long(id));
		return zone;
	}



	@Override
	public Zone getZoneByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Zone where title=:title");
		query.setParameter("title", title);
		Zone zone = (Zone)query.uniqueResult();
		return zone;
	}



	@Override
	public void deleteZone(long id) {
		Session session = sessionFactory.getCurrentSession();
		Zone zone = (Zone) session.load(Zone.class, new Long(id));
		if(zone != null)
		{
			session.delete(zone);
		}
	}

}
