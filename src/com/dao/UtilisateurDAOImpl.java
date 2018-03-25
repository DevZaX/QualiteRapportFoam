package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.index.UtilisateurIndex;
import com.model.Utilisateur;
import com.model.UtilisateurRole;



@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		sessionFactory = sf;
	}
	
	

	@Override
	public void addUtilisateur(Utilisateur u) {
		Session session = sessionFactory.getCurrentSession();
		session.save(u);
		
	}



	@Override
	public Utilisateur getUtilisateurById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur utilisateur = (Utilisateur)session.load(Utilisateur.class, new Long(id));
		return utilisateur;
	}



	@Override
	public List<Utilisateur> getUtilisateurByRole(UtilisateurRole utilisateurRole) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where id_user= :a");
		query.setParameter("a", utilisateurRole.getUtilisateur().getId_user());
		return (List<Utilisateur>) query.list();
	}



	@Override
	public List<Utilisateur> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur");
		return query.list();
		
	}



	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur utilisateur = (Utilisateur)session.load(Utilisateur.class, new Long(id));
		session.delete(utilisateur);
	}



	@Override
	public Utilisateur getUtilisateurByUsername(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where username=:username");
		query.setParameter("username", name);
		return (Utilisateur)query.uniqueResult();
	}



	@Override
	public void update(Utilisateur utilisateur) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(utilisateur);
	}
	
	
}
	
