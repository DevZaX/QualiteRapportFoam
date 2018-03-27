package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.index.DefautInjectionIndex;
import com.model.DefautControl;
import com.model.DefautControlMur;

public class DefautControlMurDAOImpl implements DefautControlMurDAO {
	
	
	private SessionFactory sessionFactory;

	


    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void addDefautControl(DefautControlMur defautControl) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(defautControl);
	}



	@Override
	public List<Object> getQteAndCodeByType(Long id, String type) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) as qte,code from DefautControlMur where control_id=:id and type=:type group by code");
		sqlQuery.setParameter("id", id);
		sqlQuery.setParameter("type", type);
		return sqlQuery.list();

	}



	@Override
	public DefautControlMur getDefautControlByControlIdAndTypeAndCode(Long id,String type,String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DefautControlMur where control_id = :id and type = :type and code = :code");
		query.setParameter("id", id);
		query.setParameter("type", type);
		query.setParameter("code", code);
		return (DefautControlMur) query.uniqueResult();
	}



	@Override
	public void update(DefautControlMur dc) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(dc);
		
	}

}
