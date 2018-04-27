package com.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ControlInjection;
import com.model.ControleInjection;
import com.model.ControleMur;

@Repository
public class ControleMurDAOImpl implements ControleMurDAO {
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(ControleMur c) {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		
	}

	@Override
	public ControleMur getByDateAndRefAndMatAndTypeAndCode(Date start, Date end, String ref, String mat,
			String type, String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleMur where date between :start and :end and ref=:ref and matricule=:mat and type=:type and code=:code");
		query.setParameter("start", start);
		query.setParameter("end", end);
		query.setParameter("ref", ref);
		query.setParameter("type", type);
		query.setParameter("code", code);
		query.setParameter("mat", mat);
		return  (ControleMur) query.uniqueResult();
	}

	@Override
	public void update(ControleMur c) {
		Session session = sessionFactory.getCurrentSession();
		session.update(c);
		
	}

	@Override
	public List<Object> execute(String r) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(r);
		return sqlQuery.list();
	}

	@Override
	public int getInt(String r) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("date1", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		sqlQuery.setParameter("date2", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		if(sqlQuery.list().get(0) == null) return 0;
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public int getQteByProjet(Date date_debut, Date date_fin, String type, String title) {
		Session session = sessionFactory.getCurrentSession();
		String r = "select count(qte) from ControleMur where date between :start and :end and type = :type and projet = :title";
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("start", date_debut);
		sqlQuery.setParameter("end", date_fin);
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("title", title);
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public double getQteByFamille(Date date_debut, Date date_fin, String type, String title) {
		Session session = sessionFactory.getCurrentSession();
		String r = "select count(qte) from ControleMur where date between :start and :end and type = :type and famille = :title";
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("start", date_debut);
		sqlQuery.setParameter("end", date_fin);
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("title", title);
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public double getQteByVersion(Date date_debut, Date date_fin, String type, String version) {
		Session session = sessionFactory.getCurrentSession();
		String r = "select count(qte) from ControleMur where date between :start and :end and type = :type and version = :version";
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("start", date_debut);
		sqlQuery.setParameter("end", date_fin);
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("version", version);
		return (int) sqlQuery.list().get(0);
	}
	
	@Override
	public ControleMur findByRef(String string) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleMur where ref = :ref");
	    query.setParameter("ref", string);
	    return (ControleMur) query.uniqueResult();
		
	}

	
	@Override
	public List<String> filterRef(Date start, Date end, String prototype, String equipe) {
		Session session = sessionFactory.getCurrentSession();
		String requete="select distinct  e.ref from ControleMur e where date between :date_debut and :date_fin";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut",start);
		query.setParameter("date_fin",end);
        return query.list();
	}

	@Override
	public ControleMur getControleMurById(Long id) {
		Session session1 = sessionFactory.getCurrentSession();
		return (ControleMur) session1.load(ControleMur.class, new Long(id));
	}

	@Override
	public int getQteByTypeAndRef(Date date1, Date date2, String type, String ref) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) from ControleMur where date between :date1 and :date2 and  type=:type and ref=:ref");
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("ref", ref);
		sqlQuery.setParameter("date1", date1);
		sqlQuery.setParameter("date2", date2);
		if(sqlQuery.list().get(0) == null) return 0;
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public List<ControleMur> getControlesMurByRef(Date date1, Date date2, String ref) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleMur where date between :date1 and :date2 and ref=:ref");
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		query.setParameter("ref", ref);
		return query.list();
	}

	@Override
	public List<ControleMur> getControlesMur(Date date1, Date date2) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleMur where date between :date1 and :date2");
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		return query.list();
	}

	@Override
	public int getQteByType(Date date1, Date date2, String type) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) from ControleMur where date between :date1 and :date2 and  type=:type");
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("date1", date1);
		sqlQuery.setParameter("date2", date2);
		if(sqlQuery.list().get(0) == null) return 0;
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public List<ControleMur> filter(Date start, Date end,String prototype, String equipe) {
		Session session = sessionFactory.getCurrentSession();
		String requete="from ControleMur where date between :date_debut and :date_fin";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut",start);
		query.setParameter("date_fin",end);
		return query.list();
	}

	


	
	
}
