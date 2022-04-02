package com.cts.automation.pageObjectModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cts.automation.baseClass.BaseClass;

public class ProductPage extends BaseClass {

	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Price -- Low to High']")
	public WebElement sortPrice;
	@FindBy(xpath = "//div[@class='_30jeq3 _1_WHN1']")
	List<WebElement> priceaftersorting;
	@FindBy(xpath = "//div[text()='SAMSUNG 123 cm (49 inch) Full HD LED Smart TV']")
	public WebElement lastProductClick;
	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	public WebElement nextpagePriceTxt;
	@FindBy(xpath = "//span[text()='SAMSUNG 123 cm (49 inch) Full HD LED Smart TV']")
	public WebElement beforeAddtocartNameTxt;
	@FindBy(xpath = "(//div[text()='₹37,999'])[1]")
	public WebElement beforeAddtocartPriceTxt;
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement addToCartBtn;
	@FindBy(xpath = "//a[text()='Explore']")
	public WebElement homeLinkTxt;
	@FindBy(xpath = "//span[text()='Cart']")
	public WebElement cartLinkTxt;
	@FindBy(xpath = "//a[text()='SAMSUNG 123 cm (49 inch) Full HD LED Smart TV']")
	public WebElement afterAddtocartNameTxt;
	@FindBy(xpath = "//span[text()='37,999']")
	public WebElement afterAddtocartPriceTxt;



	public void clickSort() throws InterruptedException
	{
		sortPrice.click();
		Thread.sleep(5000);
		List<Integer> afterprice = new ArrayList<Integer>();
		for(WebElement price: priceaftersorting)
		{
			afterprice.add(Integer.valueOf(price.getText().replaceAll("₹", "").replaceAll(",", "")));
		}
		System.out.println("The price after sorting and inserted into list:");
		System.out.println("=========================");
		System.out.println(afterprice);
		System.out.println();
		List<Integer> temp = new ArrayList<Integer>(afterprice);
		Collections.sort(temp);
		boolean sort = temp.equals(afterprice);
		System.out.println("Checking whether the price is sorted or not:");
		System.out.println(sort);
		System.out.println();
		lastProductClick.click();
		windowHandles();
		Integer max = Collections.max(afterprice);
		System.out.println("The product having maximum price which is inserted into the list: ");
		System.out.println("=================================================================");
		System.out.println();
		System.out.println(max);
		System.out.println();
		Integer Maxprice = Integer.parseInt(nextpagePriceTxt.getText().replaceAll("₹", "").replaceAll(",", ""));	
		System.out.println("The product having maximum price which is clicked and its price is displayed below: ");
		System.out.println("=================================================================");
		System.out.println();
		System.out.println(Maxprice);
		System.out.println();
		boolean equals = max.equals(Maxprice);
		System.out.println("Now checking whether the maximum price of previous page and present page is same or not:");
		System.out.println();
		System.out.println(equals);
		String nameBeforeAddToCart = beforeAddtocartNameTxt.getText();
		System.out.println(nameBeforeAddToCart);
		String priceBeforeAddToCart = beforeAddtocartPriceTxt.getText().replaceAll("₹", "").replaceAll(",", "");
		System.out.println(priceBeforeAddToCart);
		addToCartBtn.click();
		Thread.sleep(5000);
		homeLinkTxt.click();
		Thread.sleep(3000);
		cartLinkTxt.click();
		String nameAfterAddToCart = afterAddtocartNameTxt.getText();
		System.out.println(nameAfterAddToCart);
		String priceAfterAddToCart = afterAddtocartPriceTxt.getText().replaceAll(",", "").replaceAll("₹", "");
		System.out.println(priceAfterAddToCart);
				if(nameBeforeAddToCart.equals(nameAfterAddToCart))
				{
					System.out.println("Both names are equal");
				}
				else {
					System.out.println("Both names are not equal");
				}
				
				if(priceBeforeAddToCart.equals(priceAfterAddToCart))
				{
					System.out.println("Both prices are equal");
				}
				else {
					System.out.println("Both prices are not equal");
				}
				
			}
	}




//For checking sorting function
//boolean sorted = Ordering.natural().isOrdered(List);
//System.out.println("Checking whether the price is sorted or not:");
//System.out.println(sorted);
