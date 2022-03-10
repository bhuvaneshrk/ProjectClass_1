package org.test.project;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.test.baseclass.BaseClass;

public class MainClass extends BaseClass{
	public static void main(String[] args) throws AWTException {
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitlyWait(20);
		escapeKeyPress();
		PomHomePage p1=new PomHomePage();
		sendKeys(p1.getTxtSearchBar(), "Iphone");
		enterKey();
		PomProductPage p2=new PomProductPage();
		List<WebElement> list = p2.getProducts();
		for (int i = 1; i <list.size()-5; i++) {
			System.out.println(list.get(i).getText());
		}
		
	}	
}

