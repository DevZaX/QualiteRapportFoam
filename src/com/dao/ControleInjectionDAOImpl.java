package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ControleInjection;

@Repository
public class ControleInjectionDAOImpl implements ControleInjectionDAO {
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(ControleInjection c) {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		
	}

	@Override
	public ControleInjection getByDateAndRefAndMatAndTypeAndCode(Date start, Date end, String ref, String mat,
			String type, String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleInjection where date between :start and :end and ref=:ref and matricule=:mat and type=:type and code=:code");
		query.setParameter("start", start);
		query.setParameter("end", end);
		query.setParameter("ref", ref);
		query.setParameter("type", type);
		query.setParameter("code", code);
		query.setParameter("mat", mat);
		return  (ControleInjection) query.uniqueResult();
	}

	@Override
	public void update(ControleInjection c) {
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
		String r = "select sum(qte) from ControleInjection where date between :start and :end and type = :type and projet = :title";
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("start", date_debut);
		sqlQuery.setParameter("end", date_fin);
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("title", title);
		if(sqlQuery.list().get(0) == null) {
			return 0;
		}
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public double getQteByFamille(Date date_debut, Date date_fin, String type, String title) {
		Session session = sessionFactory.getCurrentSession();
		String r = "select sum(qte) from ControleInjection where date between :start and :end and type = :type and famille = :title";
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
		String r = "select sum(qte) from ControleInjection where date between :start and :end and type = :type and version = :version";
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("start", date_debut);
		sqlQuery.setParameter("end", date_fin);
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("version", version);
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public List<Object> getDefautsBy(Date date_debut, Date date_fin, String zone, String shift, String equipe,
			String projet, String famille, String version, String prototype,String type_value) {
		Session session = sessionFactory.getCurrentSession();
		String requete = "select top 10 code,sum(qte) from ControleInjection where date between :date_debut and :date_fin";
		if(!zone.equals("All")) requete = requete + " and zone='"+zone+"'";
		if(!shift.equals("All")) requete = requete + " and shift='"+shift+"'";
		if(!equipe.equals("All")) requete = requete + " and equipe='"+equipe+"'";
		if(!prototype.equals("All")) requete = requete + "and prototype='"+prototype+"'";
		if(!projet.equals("")) requete = requete + " and projet='"+projet+"'";
		if(!famille.equals("")) requete = requete + " and famille='"+famille+"'";
		if(!version.equals("")) requete = requete + " and version='"+version+"'";
		if(!type_value.equals("All")) requete = requete + " and type='"+type_value+"'";
		requete = requete + " group by code";
		System.out.println(requete);
		SQLQuery sqlQuery = session.createSQLQuery(requete);
		sqlQuery.setParameter("date_debut", date_debut);
		sqlQuery.setParameter("date_fin", date_fin);
		return sqlQuery.list();
	}

	@Override
	public List<Object> getQteAndProjectsByDefaut(Date date_debut, Date date_fin, String defaut) {
		Session session = sessionFactory.getCurrentSession();
		String requete = "select projet,sum(qte) from ControleInjection where date between :date_debut and :date_fin and code = :code group by projet";
		SQLQuery sqlQuery = session.createSQLQuery(requete);
		sqlQuery.setParameter("date_debut", date_debut);
		sqlQuery.setParameter("date_fin", date_fin);
		sqlQuery.setParameter("code", defaut);
		return sqlQuery.list();
	}

	@Override
	public List<Object> execute(Date date_debut, Date date_fin, String r) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(r);
		sqlQuery.setParameter("date_debut", date_debut);
		sqlQuery.setParameter("date_fin", date_fin);
		return sqlQuery.list();
	}

	@Override
	public int getQteByTypeAndRef(Date date1, Date date2, String type, String ref) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) from ControleInjection where date between :date1 and :date2 and  type=:type and ref=:ref");
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("ref", ref);
		sqlQuery.setParameter("date1", date1);
		sqlQuery.setParameter("date2", date2);
		if(sqlQuery.list().get(0) == null) {
			return 0;
		}
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public List<ControleInjection> getControlesInjectionByRef(Date date1, Date date2, String ref) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleInjection where date between :date1 and :date2 and ref=:ref");
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		query.setParameter("ref", ref);
		return query.list();
	}

	@Override
	public List<ControleInjection> getControlesInjection(Date date1,Date date2) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ControleInjection where date between :date1 and :date2");
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		return query.list();
	}

	@Override
	public int getQteByType(Date date1,Date date2,String type) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) from ControleInjection where date between :date1 and :date2 and  type=:type");
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("date1", date1);
		sqlQuery.setParameter("date2", date2);
		if(sqlQuery.list().get(0) == null) return 0;
		return (int) sqlQuery.list().get(0);
	}

	@Override
	public List<ControleInjection> filter(Date start, Date end, String zone, String prototype, String equipe) {
		Session session = sessionFactory.getCurrentSession();
		String requete="from ControleInjection where date between :date_debut and :date_fin";
		if(!zone.equals("All")) requete = requete + " and  zone = '" + zone + "'";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut",start);
		query.setParameter("date_fin",end);
		return query.list();
	}

	@Override
	public List<String> filterRef(Date start, Date end, String zone, String prototype, String equipe) {
		Session session = sessionFactory.getCurrentSession();
		String requete="select distinct  e.ref from ControleInjection e where date between :date_debut and :date_fin";
		if(!zone.equals("All")) requete = requete + " and  zone = '" + zone + "'";
		if(!prototype.equals("All")) requete = requete + " and  prototype = '" + prototype + "'";
		if(!equipe.equals("All")) requete = requete + " and equipe = '" + equipe + "'";
		System.err.println(requete);
		Query query = session.createQuery(requete);
		query.setParameter("date_debut",start);
		query.setParameter("date_fin",end);
        return query.list();
	}

	@Override
	public ControleInjection getControleInjectionById(Long id) {
		Session session1 = sessionFactory.getCurrentSession();
		return (ControleInjection) session1.load(ControleInjection.class, new Long(id));
	}

	@Override
	public int getQteByDateAndRefAndMatAndType(Date start, Date end, String ref, String mat, String type) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) from ControleInjection where date between :start and :end and  type=:type and matricule=:mat and ref=:ref");
		sqlQuery.setParameter("start", start);
		sqlQuery.setParameter("end", end);
		sqlQuery.setParameter("ref", ref);
		sqlQuery.setParameter("type", type);
		sqlQuery.setParameter("mat", mat);
	   
			
		
		if(sqlQuery.list().get(0) == null) {
			return 0;
		}
		return  (int) sqlQuery.list().get(0);
		
	}

}
