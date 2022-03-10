package org.test.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	//Browser Launch
	public static void browserLaunch(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Unknown Url");
	}
}
	//Launch URL
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	//get title
	public static String getTitle() {
		 return driver.getTitle();
		 
	}
	
	//quit
	public static void quit() {
		driver.quit();
	}
	
	//sendkeys
	public static void sendKeys(WebElement we,String value) {
		we.sendKeys(value);
	}
	
	//click
	public static void click(WebElement we) {
		we.click();
	}
	
	//gettext
	public static void getText(WebElement we) {
		we.getText();
	}
	
	//get attribute value
	public static void getAttributeValue(WebElement we) {
		 we.getAttribute("Value");
	}
	
	//get attribute innertext
	public static void getAttributeInnerText(WebElement we) {
		we.getAttribute("innerText");
	}
	
	//Implicitly Wait
	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	//sleep
	public static void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}
	
	//movetoelement
	public static void moveToElement(WebElement we) {
		Actions action=new Actions(driver);
		action.moveToElement(we).perform();
	}
	
	//Drag and Drop
	public static void dragAndDrop(WebElement source,WebElement destination) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination).perform();;
	}
	
	//ContextClick
	public static void contextClick(WebElement we) {
		Actions action=new Actions(driver);
		action.contextClick(we).perform();;
	}
	
	//Double click
	public static void doubleClick(WebElement we) {
		Actions action=new Actions(driver);
		action.doubleClick(we).perform();;
	}
	
	//down key Press
	public static void downKeyPress() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
	}
	
	//down key Release
	public static void downKeyRelease() throws AWTException {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	//enter key
	public static void enterKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//Backspace key
		public static void backSpaceKey() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
	
	//shift key press
	public static void shiftKeyPress() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
	}
	
	//shift key release
	public static void shiftKeyRelease() throws AWTException {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	//escape key press
	public static void escapeKeyPress() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	//copy
	public static void copy() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	//paste
	public static void paste() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	//accept Alert
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	//dismiss Alert
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	//sendkeys Alert
	public static void sendKeysAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	//getText Alert
	public static String sendKeysAlert() {
		return driver.switchTo().alert().getText();
	}
	
	//dropDown Select by index
	public static void dropDownSelectByIndex(WebElement we,int index) {
		Select s=new Select(we);
		s.selectByIndex(index);
	}
	
	//dropDown Select by Value
	public static void dropDownSelectByValue(WebElement we,String value) {
		Select s=new Select(we);
		s.selectByValue(value);
	}
	
	//dropDown Select by VisibleText
	public static void dropDownSelectByVisibleText(WebElement we,String value) {
		Select s=new Select(we);
		s.selectByVisibleText(value);
	}
	
	//dropDown Deselect by index
	public static void dropDownDeselectByIndex(WebElement we,int index) {
		Select s=new Select(we);
		s.deselectByIndex(index);
	}
		
	//dropDown Deselect by Value
	public static void dropDownDeselectByValue(WebElement we,String value) {
		Select s=new Select(we);
		s.deselectByValue(value);
	}
		
	//dropDown Deselect by VisibleText
	public static void dropDownDeselectByVisibleText(WebElement we,String value) {
		Select s=new Select(we);
		s.deselectByVisibleText(value);
	}
	
	//dropDown get Options
	public static List<WebElement> dropDownGetOptions(WebElement we) {
		Select s=new Select(we);
		return s.getOptions();
	}
	
	//dropDown get all selected options
	public static List<WebElement> dropDownGetAllSelectedOptions(WebElement we) {
		Select s=new Select(we);
		return s.getAllSelectedOptions();
	}
	
	//dropDown get first selected option
	public static WebElement dropDownGetFirstSelectedOption(WebElement we) {
		Select s=new Select(we);
		return s.getFirstSelectedOption();
	}
	
	//dropDown ismultiple
	public static boolean dropDownIsMultiple(WebElement we) {
		Select s=new Select(we);
		return s.isMultiple();
	}
	
	//dropDown Deselect All
	public static void dropDownDeselectAll(WebElement we) {
		Select s=new Select(we);
		s.deselectAll();
	}
	
	//screenshot
	public static void screenShot(String name) throws IOException {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Admin\\eclipse-workspace\\Maven_Work\\src\\test\\resources\\ScreenShot\\"+name+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	//navigate to url
	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}
	
	//navigate back
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	//navigate forward
	public static void navigateForward() {
		driver.navigate().forward();
	}
	
	//navigate refresh
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	
	//navigate isDisplayed
	public static boolean navigateIsDisplayed(WebElement we) {
		return we.isDisplayed();
	}
	
	//navigate isEnabled
	public static boolean navigateIsEnabled(WebElement we)	{
		return we.isEnabled();
	}
	
	//navigate isSelected
	public static boolean navigateIsSelected(WebElement we) {
		return we.isSelected();
	}
	
	//insert value using javascript
	public static void javaScriptInsert(WebElement we,String arguments) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(arguments, we);
	}
	
	//get value using javascript
	public static String javaScriptGet(WebElement we,String arguments) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object executeScript = js.executeScript("return argument[0].getAttribute('value')", we);
		return executeScript.toString();
	}
	
	//clickk using javaScript
	public static void javaScriptClick(WebElement we) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", we);
	}
	
	//scroll down
	public static void scrollDown(WebElement we) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", we);
		Thread.sleep(3000);
	}
	
	//scroll up
		public static void scrollUp(WebElement we) throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", we);
			Thread.sleep(3000);
		}
	
	//switch to frame
		public static void switchToFrame(String frameIdorName) {
			driver.switchTo().frame(frameIdorName);
		}
		
	//come out from frame
		public static void switchToDefaultFrame() {
			driver.switchTo().defaultContent();
		}
	
	//switch to inner frame
		public static void switchToInnerFrame() {
			driver.switchTo().frame(0);
		}
	
	//switch to inner frame
		public static void switchToParentFrame() {
			driver.switchTo().parentFrame();
		}
	
	//to get parent windows id 
		public static String parentWindowsId() {
			return driver.getWindowHandle();
		}
	
	//to get all windows id
		public static void allWindowsId(int input) {
			Set<String> allId = driver.getWindowHandles();
			List<String> li=new LinkedList<>();
			li.addAll(allId);
			driver.switchTo().window(li.get(input));
		}
		//get excel data
 		public static String getExcelData (String filename,String sheetname,int rowno,int cellno) throws IOException {
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\"+filename+".xlsx");
		 FileInputStream fis=new FileInputStream(f);
		 Workbook w=new XSSFWorkbook(fis);
		 Sheet sheet = w.getSheet(sheetname);
		 Row row = sheet.getRow(rowno);
		 Cell cell = row.getCell(cellno);
		 int type = cell.getCellType();
		 
		 //type=1    String
		 //type=0	Numbers,Date
		 
		 String value=null;
		if(type==1) {
			 value = cell.getStringCellValue();
		 }
		 else {
			 if(DateUtil.isCellDateFormatted(cell)) {
				value = new SimpleDateFormat("dd-mmm-yyyy").format(cell.getDateCellValue());
			 }
			 else {
				 value = String.valueOf((long)cell.getNumericCellValue());
			 }
		 }
		return value;
 		}
 		
 		}
