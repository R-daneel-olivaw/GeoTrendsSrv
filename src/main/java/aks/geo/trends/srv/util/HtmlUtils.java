package aks.geo.trends.srv.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlUtils {
	
	public List<String> parseRelated (String html)
	{
		Document doc = Jsoup.parse(html);
		Elements links = doc.select("span");
		System.out.println("Span Length = "+links.size());
		
		List<String> relatedList = new ArrayList<>();
		
		for (Element link : links) {
			
			System.out.println(link.className());
			
//			String text = link.select("a").first().text();
//			relatedList.add(text);
		}
		
		return relatedList;		
	}

}
