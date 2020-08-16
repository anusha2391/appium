package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage 
{
	public HomePage(AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement namefield;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
     
     @AndroidFindBy(id="android:id/text1")
     private WebElement countrySelection;
     
     @AndroidFindBy(xpath="//*[@text='Argentina']")
     public WebElement countryname;
     
     @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
     public WebElement Letsshopbtn;
     
     public WebElement getNameField()
     {
    	 System.out.println("Enter the name");
		return namefield;
     }
     public WebElement getcountrySelection()
 	{
 		System.out.println("Selecting the option from dropdown");
 		return countrySelection;
 	}
     
}
