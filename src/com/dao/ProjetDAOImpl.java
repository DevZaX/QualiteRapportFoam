package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Projet;

@Repository
public class ProjetDAOImpl implements ProjetDAO {
	
   private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdateProjet(Projet projet) {
		Session session = sessionFactory.getCurrentSession();
		if(getProjetByTitle(projet.getTitle()) != null)
		{
			session.update(projet);
		}else {
			session.save(projet);	
		}
		
	}

	@Override
	public Projet getProjetById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Projet projet = (Projet) session.load(Projet.class,new Long(id));
		return projet;
	}

	@Override
	public List<Projet> getProjets() {
		Session session = sessionFactory.getCurrentSession();
		List<Projet> projets = session.createQuery("from Projet").list();
		return projets;
	}

	@Override
	public Projet getProjetByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Projet where title=:title");
		query.setParameter("title", title);
		Projet projet = (Projet)query.uniqueResult();
		return projet;
	}

	@Override
	public List<Projet> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Projet").list();
	}

	@Override
	public void delete(Long id) {
		
		    Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update Projet set etat=0 where id=:id");
			query.setParameter("id", id);
		
	}
	
	

}
