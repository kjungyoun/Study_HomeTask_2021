package com.ssafy.news;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{
	private List<News> list = new ArrayList<News>();
	
	@Override
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectNews(url);
		return list;
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}
	
	private void connectNews(String url) {
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(),handler);
			
		}catch (Exception e) {
			throw new RuntimeException("뉴스를 전송 받는 중 오류 발생");
//			e.printStackTrace();
		}
	}
	
	public class SAXHandler extends DefaultHandler{
		String temp;
		News n;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(qName.equals("item"))
				n = new News();
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			temp = new String(ch,start,length);
		}
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("title")) {
				n.setTitle(temp);
			}else if(qName.equals("link")){
				n.setLink(temp);
			}else if(qName.equals("description")) {
				n.setDesc(temp);
			}else if(qName.equals("item")) {
				list.add(n);
			}
		}
	}
}
