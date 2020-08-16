package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage 
{
	public CheckoutPage(AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> productlist;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> productAddCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartbtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement productname;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
	public WebElement backbtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> pricelist;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public  WebElement totalamount;
	

}
