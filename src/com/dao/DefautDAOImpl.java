package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Defaut;

@Repository
public class DefautDAOImpl implements DefautDAO{

	private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void addDefaut(Defaut defaut) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(defaut);
	}



	@Override
	public Defaut getDefautByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Defaut where code=:code");
		query.setParameter("code", code);
		Defaut defaut = (Defaut)query.uniqueResult();
		return defaut;
	}



	


	@Override
	public void removeDefaut(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Defaut where code=:code");
		query.setParameter("code", code);
		Defaut defaut = (Defaut)query.uniqueResult();
		if(defaut != null)
		{
			session.delete(defaut);
		}
		
	}



	@Override
	public Defaut getDefautByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Defaut where title=:title");
		query.setParameter("title", title);
		Defaut defaut = (Defaut)query.uniqueResult();
		return defaut;
	}



	@Override
	public List<Defaut> listDefaut() {
		Session session = sessionFactory.getCurrentSession();
		List<Defaut> defauts = new ArrayList<>();
		defauts = session.createQuery("from Defaut").list();
		return defauts;
	}



	@Override
	public List<Defaut> findBySide(String string) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Defaut where side=:string");
		query.setParameter("string", string);
		return query.list();
	}
	
	

}
