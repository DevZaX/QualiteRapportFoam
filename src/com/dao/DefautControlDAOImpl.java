package com.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.index.DefautInjectionIndex;
import com.model.DefautControl;

public class DefautControlDAOImpl implements DefautControlDAO {
	
	
	private SessionFactory sessionFactory;

	


    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void addDefautControl(DefautControl defautControl) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(defautControl);
	}



	@Override
	public List<Object> getQteAndCodeByType(Long id, String type) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select sum(qte) as qte,code from DefautControl where control_id=:id and type=:type group by code");
		sqlQuery.setParameter("id", id);
		sqlQuery.setParameter("type", type);
		return sqlQuery.list();

	}

}
