package Testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Appium_Base.Base;
import Appium_Base.Excellib;
import Appium_Base.Testdata;
import Appium_Base.utilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;



public class Ecommerce_tc extends Base 
{
	public Excellib lib= new  Excellib();
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;



	@BeforeMethod
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		
		
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(1000);
		
		
				
	}
	
	@Test(dataProvider="inputdata",dataProviderClass=Testdata.class)
	public void testNamefield(String name) throws IOException, InterruptedException
	{
		
		service=startServer();
		System.out.print("Appium server started");
		AndroidDriver<MobileElement>driver=capabilities("GeneralStoreApp","deviceName","platformName","platformVersion");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		HomePage h= new HomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(h.getNameField()));
		h.getNameField().sendKeys(name);
		
	}
	/*@Test
	public void Zdummy() throws IOException
	{
		//service=startServer();
		System.out.print("Appium server started");
		AndroidDriver<MobileElement>driver=capabilities("GeneralStoreApp","deviceName","platformName","platformVersion");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		HomePage h= new HomePage(driver);
		
		h.getNameField().sendKeys("AAA");
		
	}*/
	
	@Test
	public void testproductValidation() throws IOException, IllegalFormatException, InvalidFormatException, InterruptedException 
	{
		
		String name=Excellib.getData("\\src\\Testdata.xlsx", "Testdata.xlsx","data", 1, 0);
		String country=Excellib.getData("\\src\\Testdata.xlsx","Testdata.xlsx", "data", 1, 1);
		
		service=startServer();
		System.out.print("Appium server started");
		AndroidDriver<MobileElement>driver=capabilities("GeneralStoreApp","deviceName","platformName","platformVersion");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		HomePage h= new HomePage(driver);
		
		System.out.println(name);
		h.getNameField().sendKeys(name);
		driver.hideKeyboard();
		h.femaleOption.click();
		h.getcountrySelection().click();
		utilities u=new utilities(driver);
		
		u.scrollToText(country);
		h.countryname.click();
		h.Letsshopbtn.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
		        + "new UiSelector().text(\"Air Jordan 4 Retro\"));");
		
		CheckoutPage c=new CheckoutPage(driver);
		int count=c.productlist.size();
		for(int i=0;i<count;i++)
	     {

	        String text=c.productlist.get(i).getText();
	     
		    if(text.equalsIgnoreCase("Air Jordan 4 Retro")|| text.equalsIgnoreCase("Air Jordan 1 Mid SE"))

		     {
			    c.productAddCart.get(i).click();
			    c.productAddCart.get(i+1).click();
			  
		    	break;

		     }
		     
		    
		  }
	    c.cartbtn.click();
	   
	    
	    //String Productname=  c.productname.getText();
	    //Assert.assertEquals(Productname, "Air Jordan 4 Retro");
		System.out.println("success");
		int count1=c.pricelist.size();
		double sum=0;
		
		for(int i=0;i<count1;i++)
		{ 
			String amount=c.pricelist.get(i).getText();
			double actualamount=getAmount(amount);
			sum=sum+actualamount;
		}
		String tamount=c.totalamount.getText();
		double totalamount=getAmount(tamount);
		System.out.println(totalamount);
		Assert.assertEquals(sum, totalamount);
	}
	
	
	public static double getAmount(String value)
	{
		value= value.substring(1);
		System.out.println(value);
		double amount2value=Double.parseDouble(value);
		return amount2value;
		
		
	}
	
	
	
	
	

}
