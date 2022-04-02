package com.cts.automation.stepdef;

import com.cts.automation.baseClass.BaseClass;
import com.cts.automation.pageObjectModel.LoginPage;
import com.cts.automation.pageObjectModel.ProductPage;
import com.cts.automation.pageObjectModel.SearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartStepdef extends BaseClass{
	
	@Given("launch chrome and navigate to Flipkart url")
	public void launchChromeAndNavigateURL() {
		launchChrome();
		driver.get("https://www.flipkart.com/");
	 
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String string, String string2) throws InterruptedException {
		
		LoginPage login = new LoginPage();
		login.login(string, string2);
	 
	}

	@When("user search products as {string}")
	public void searchProdunct(String string) {
		SearchPage searchproduct = new SearchPage();
		searchproduct.search(string);
	}

	@Then("The products displayed")
	public void the_products_displayed() throws InterruptedException {
		
		ProductPage productDetails = new ProductPage();
		productDetails.clickSort();
	    
	}


}
