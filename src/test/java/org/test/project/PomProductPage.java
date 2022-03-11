package org.test.project;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.baseclass.BaseClass;

public class PomProductPage extends BaseClass{
	public PomProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> products;
	public List<WebElement> getProducts() {
		return products;
	}
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> getPrice;
	public List<WebElement> getGetPrice() {
		return getPrice;
	}
}