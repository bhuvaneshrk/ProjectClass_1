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
	@FindBy(xpath="//div[contains(text(),'APPLE')]")
	private List<WebElement> products;
	public List<WebElement> getProducts() {
		return products;
	}
}
