package aks.geo.trends.srv.spring.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aks.geo.trends.srv.hibernate.Keyword;
import aks.geo.trends.srv.hibernate.Region;

@Repository
public class KeywordsDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void saveKeywordList(List<Keyword> keywords) {

		Session session = sessionFactory.getCurrentSession();
		
		for (Keyword keyword : keywords) {
			session.save(keyword);
		}
	}

	public void removeKeywordsForRegion(Region reg) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Keyword.class);
		
		criteria.add(Restrictions.eqOrIsNull("region", reg));
		List<Keyword> list = (List<Keyword>)criteria.list();
		
		for (Keyword keyword : list) {
			
			session.delete(keyword);
		}
		
		session.flush();
	}
}
