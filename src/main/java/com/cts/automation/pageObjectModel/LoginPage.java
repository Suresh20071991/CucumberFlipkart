package com.cts.automation.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.automation.baseClass.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Enter Email/Mobile number']/../..//input")
	public WebElement userNameTxt;

	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	public WebElement pwdTxt;

	@FindBy(xpath = "(//span[text()='Login'])[2]")
	public WebElement login;

	public void login(String string, String string2) throws InterruptedException
	{

		userNameTxt.sendKeys(string);
		pwdTxt.sendKeys(string2);
		login.click();
		Thread.sleep(3000);
	}

}
