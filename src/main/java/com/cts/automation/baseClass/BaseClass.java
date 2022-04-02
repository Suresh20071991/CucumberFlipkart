package com.cts.automation.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	
	// Base class method for launching browser
	
	public static void launchChrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	//Base class method for taking screenshot

			public void screenshot(String fileName) throws IOException {

				TakesScreenshot ts = (TakesScreenshot) driver;
				File srcFile = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File(fileName));
				
			}
			
			//Base class method for drop down by select by visible text

			public void dropdownByVisibleMethod(WebElement element, String options ) {

				Select text = new Select(element);
				text.selectByVisibleText(options);

			}

			//Base class method for drop down by select by Index

			public void dropdownByIndex(WebElement element, int index) {

				Select text = new Select(element);
				text.selectByIndex(index);

			}
			
			// Reading data needed for webpage using excel
			
			public static Object[][] readExcelData(String filePath, String sheetName) throws IOException
			{
				FileInputStream fis = new FileInputStream(filePath);
				Workbook w = new XSSFWorkbook(fis);
				Sheet s = w.getSheet(sheetName);
				int totalRows = s.getPhysicalNumberOfRows();
				int totalCols = s.getRow(0).getPhysicalNumberOfCells();
				Object[][] array = new Object[totalRows][totalCols];
				for(int i=0; i<s.getPhysicalNumberOfRows(); i++) 
				{
					Row row = s.getRow(i);
					for(int j=0;j<row.getPhysicalNumberOfCells();j++)
					{
						Cell cell = row.getCell(j);
						String stringCellValue = cell.getStringCellValue();
						array[i][j]=stringCellValue;
					}
				}
				
				return array;
					
			}
	
			public void scrollingDown() {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");
			}
			
			public void moveToElement(WebElement var) {
				
				Actions acc = new Actions(driver);
				acc.moveToElement(var).click().build().perform();
				
			}
			
			// Base class for Windows Handles
			public void windowHandles() {

				Set<String> allTabs = driver.getWindowHandles();
				List<String> allTabList = new LinkedList<String>(allTabs);
				driver.switchTo().window(allTabList.get(1));
				
			}
	

}
