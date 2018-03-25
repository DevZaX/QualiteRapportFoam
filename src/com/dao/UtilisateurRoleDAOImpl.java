package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UtilisateurRole;

@Repository
public class UtilisateurRoleDAOImpl implements UtilisateurRoleDAO {
	
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	

	@Override
	public void addUtilisateurRole(UtilisateurRole utilisateurRole) {
		Session session = sessionFactory.getCurrentSession();
		session.save(utilisateurRole);
		
	}


	@Override
	public UtilisateurRole getUtilisateurRoleById(long id) {
		Session session = sessionFactory.getCurrentSession();
		UtilisateurRole utilisateurRole = (UtilisateurRole)session.load(UtilisateurRole.class, new Long(id));
		return utilisateurRole;
	}

}
