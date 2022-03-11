package org.test.project;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.test.baseclass.BaseClass;

public class MainClass extends BaseClass{
	public static void main(String[] args) throws AWTException, InterruptedException {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitlyWait(20);
		escapeKeyPress();
		PomHomePage p1=new PomHomePage();
		sendKeys(p1.getTxtSearchBar(), "Iphone");
		enterKey();
		PomProductPage p2=new PomProductPage();
		List<WebElement> productlist = p2.getProducts();
		System.out.println("=====Name of the Products Available=====");
		for (int i = 0; i <productlist.size(); i++) {
			System.out.println(productlist.get(i).getText());
		}
		System.out.println("=====Price of the Products=====");
		List<WebElement> pricelist = p2.getGetPrice();
		for (int i = 0; i <pricelist.size(); i++) {
			System.out.println(pricelist.get(i).getText());
		}
		List<String> li=new ArrayList<>();
		for (int i = 0; i < pricelist.size(); i++) {
			String text = pricelist.get(i).getText();
			String s="";
			if (text.contains("₹")) {
				s=text.replace("₹", "");	
			if (text.contains(",")) {
				String text2 = pricelist.get(i).getText();
				s=s.replace(",", "");
				li.add(s);
			}
			}
		}
		System.out.println("=====Price In ascending Order=====");
		Collections.sort(li);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
		System.out.println("=====Minimum Price=====");
		System.out.println(li.get(0));
		System.out.println("=====Maximum Price=====");
		System.out.println(li.get(li.size()-1));
		Map<String, String> mp=new TreeMap<>();
		System.out.println("=====Product=price=====");
		for (int i = 0; i < pricelist.size(); i++) {
			mp.put(productlist.get(i).getText(), li.get(i));
		}
		Set<Entry<String, String>> entrySet = mp.entrySet();
		for (Entry <String,String> x:entrySet) {
			System.out.println(x);
		}
		
		quit();
		}	
}



