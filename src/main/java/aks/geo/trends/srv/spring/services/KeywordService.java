package aks.geo.trends.srv.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aks.geo.trends.srv.hibernate.Keyword;
import aks.geo.trends.srv.spring.daos.KeywordsDao;

@Service
public class KeywordService {
	
	@Autowired
	KeywordsDao keywordDao;
	
	@Transactional
	public void updateDatabase(List<String> trending, String region) {
		// TODO Auto-generated method stub
		
		List<Keyword> keywords = convertToDbPojos(trending);
		
		keywordDao.saveKeywordList(keywords);		
	}

	private List<Keyword> convertToDbPojos(List<String> trending) {
		// TODO Auto-generated method stub
		
		List<Keyword> keywords = new ArrayList<>();
		for (String item : trending) {
			
			Keyword k = new Keyword();			
			k.setKeyword(item);
			
			keywords.add(k);
		}
		
		return keywords;
	}
}
