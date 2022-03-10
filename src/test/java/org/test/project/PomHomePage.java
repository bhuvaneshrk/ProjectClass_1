package org.test.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.baseclass.BaseClass;

public class PomHomePage extends BaseClass{
	public PomHomePage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement txtSearchBar;

	public WebElement getTxtSearchBar() {
		return txtSearchBar;
	}
	
	
	
}
