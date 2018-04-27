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
	public ControlInjection fetchAll(Date startDate, Date endDate, String ref,String matricule) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlInjection where date between :startDate and :endDate and ref = :ref and matricule=:matricule");
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    query.setParameter("ref", ref);
	    query.setParameter("matricule", matricule);
	    return (ControlInjection) query.uniqueResult();
	}


	@Override
	public ControlInjection findByRef(String string) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControlInjection where ref = :ref");
	    query.setParameter("ref", string);
	    return (ControlInjection) query.uniqueResult();
		
	}


	@Override
	public List<ControlInjection> findBy(Date startDate, Date endDate,String champ, String chose) {
		Session session = sessionFactory.getCurrentSession();
		String requete = "from ControlInjection where date between :startDate and :endDate and "+champ+" = :chose";
		System.err.println(requete);
		Query query = session.createQuery(requete);
	    query.setParameter("startDate", startDate);
	    query.setParameter("endDate", endDate);
	    query.setParameter("chose", chose);
	    return query.list();
	}


	@Override
	public List<ControlInjection> filter(Date date_debut,Date date_fin, String zone, String prototype,
			String equipe) {
		Session session = sessionFactory.getCurrentSession();
		String requete="from ControlInjection where date between :date_debut and :date_fin";
		if(!zone.equals("All")) requete = requete + " and  zone = '" + zone + "'";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut", date_debut);
		query.setParameter("date_fin",date_fin);
		return query.list();
	}
	
	
	@Override
	public List<ControlInjection> critere(Date date_debut,Date date_fin, String zone, String prototype,
			String equipe,String projet,String famille,String designation) {
		Session session = sessionFactory.getCurrentSession();
		String requete="from ControlInjection where date between :date_debut and :date_fin";
		if(!zone.equals("All")) requete = requete + " and  zone = '" + zone + "'";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		if(!projet.equals("")) requete = requete + " and projet = '" + projet + "'";
		if(!famille.equals("")) requete = requete + " and famille = '" + famille + "'";
		if(!designation.equals("")) requete = requete + " and designation = '" + designation + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut", date_debut);
		query.setParameter("date_fin",date_fin);
		return query.list();
	}


	@Override
	public ControlInjection find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (ControlInjection) session.load(ControlInjection.class, new Long(id));
	}
	
	

}
