package Testcases;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Appium_Base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import io.appium.java_client.touch.offset.ElementOption;
import pageObjects.ApiDemo_PreferencePage;
import pageObjects.ApiDemo_ViewPage;

public class ApiDemos_ViewsPage extends Base
{
   public ExtentHtmlReporter htmlReporter1;
   public ExtentReports extent1;
   public ExtentTest test1;
   
   
	@BeforeMethod
	public void killAllNodes() throws IOException, InterruptedException
	{
		
	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	
	@Test
    public void testSwipping_actions() throws InterruptedException, IOException 
	{
		
		service=startServer();
		System.out.print("Appium server started");
		AndroidDriver<MobileElement>driver=capabilities("apiDemo","deviceName","platformName","platformVersion");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ApiDemo_ViewPage viewpage=new ApiDemo_ViewPage(driver);
        TouchAction t=new TouchAction(d);
        WebElement views= viewpage.viewsbtn;
        		
        t.tap(tapOptions().withElement(element(views))).perform();
        /*d.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
        d.findElement(By.id("io.appium.android.apis:id/sign_in_button")).click(); */
        
        
        //d.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
   
        viewpage.DateWidgets.click();
        viewpage.inlinebtn.click();
        viewpage.content_desc_9.click();
        WebElement first= viewpage.content_desc_15;
    		 
        WebElement second= viewpage.content_desc_45;
    		
       //Swapping gestures
       
       t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
      System.out.println("Swapping gestures: sucess");
	}
	
	@Test
    public void testlongPress_function() throws InterruptedException, IOException
    {
		
		service=startServer();
		//android.widget.TextView[@text='Preference']
		AndroidDriver<MobileElement>driver=capabilities("apiDemo","deviceName","platformName","platformVersion");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ApiDemo_ViewPage viewpage=new ApiDemo_ViewPage(driver);
		viewpage.viewsbtn.click();
		viewpage.ExpandableLists.click();
		viewpage.CustomAdapter.click();
		WebElement pn=	driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		TouchAction t= new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();	
		
    }
	
	@Test
	public void testDragandDrop_function() throws InterruptedException,IOException
	{

		
		service=startServer();
		//android.widget.TextView[@text='Preference']
		AndroidDriver<MobileElement>driver=capabilities("apiDemo","deviceName","platformName","platformVersion");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ApiDemo_ViewPage viewpage=new ApiDemo_ViewPage(driver);
		viewpage.viewsbtn.click();
		viewpage.draganddropbtn.click();
		 WebElement firstele=viewpage.item1;
		 WebElement secondele=viewpage.item2;
		 TouchAction t=new TouchAction(driver);
		 t.longPress(longPressOptions().withElement(element(firstele))).moveTo(element(secondele)).release().perform();
		 
		
	}

	
	

	

}
