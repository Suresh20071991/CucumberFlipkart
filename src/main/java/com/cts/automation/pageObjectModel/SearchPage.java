package com.cts.automation.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.automation.baseClass.BaseClass;

public class SearchPage extends BaseClass{
	
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchTxtBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement searchBtn;
	
	public void search(String string)
	{
		searchTxtBox.click();
		searchTxtBox.sendKeys(string);
		searchBtn.click();
	}


}
