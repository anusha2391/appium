package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemo_PreferencePage 
{
	public ApiDemo_PreferencePage(AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement preferencebtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement Preference_dependenciesbtn;
	
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement wifibtn;
	
	@AndroidFindBy(className="(//android.widget.RelativeLayout)[1]")
	public WebElement relativelayoutbtn;
	
	
	
	}
	

