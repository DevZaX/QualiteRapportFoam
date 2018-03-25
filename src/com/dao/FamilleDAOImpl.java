package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Famille;


@Repository
public class FamilleDAOImpl implements FamilleDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(Famille famille) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(famille);
		Famille ft = getFamilleByTitle(famille.getTitle());
		if(ft != null)
		{
			session.update(ft);
		}else {
			session.save(ft);
		}
	}
	
	
	@Override
	public void update(Famille famille) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(famille);
		
		
	}


	@Override
	public Famille getFamilleByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Famille where title=:title");
		q.setParameter("title", title);
		Famille famille = (Famille)q.uniqueResult();
		return famille;
	}



	@Override
	public List<Famille> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Famille").list();
	}

}
