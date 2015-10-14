package aks.geo.trends.srv.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aks.geo.trends.srv.hibernate.Keyword;
import aks.geo.trends.srv.hibernate.Region;
import aks.geo.trends.srv.spring.daos.KeywordsDao;
import aks.geo.trends.srv.spring.daos.RegionsDao;

@Service
public class KeywordService {
	
	@Autowired
	KeywordsDao keywordDao;
	
	@Autowired
	RegionsDao regionsDao;
	
	@Transactional
	public void updateDatabase(List<String> trending, String region) {
		
		Region reg = regionsDao.getRegion(region);
		if(reg==null)
		{
			reg = new Region();
			reg.setRegion(region);
			
			regionsDao.saveRegion(reg);
		}
		
		keywordDao.removeKeywordsForRegion(reg);		
		
		List<Keyword> keywords = convertToDbPojos(trending, reg);
		keywordDao.saveKeywordList(keywords);		
	}

	private List<Keyword> convertToDbPojos(List<String> trending, Region reg) {
		// TODO Auto-generated method stub
		
		List<Keyword> keywords = new ArrayList<>();
		for (String item : trending) {
			
			Keyword k = new Keyword();			
			k.setKeyword(item);
			k.setRegion(reg);
			
			keywords.add(k);
		}
		
		return keywords;
	}
}
