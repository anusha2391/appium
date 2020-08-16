package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemo_ViewPage 
{
   
	public  ApiDemo_ViewPage (AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	public WebElement viewsbtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
	public WebElement DateWidgets;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2. Inline']")
	public WebElement inlinebtn;
	
	@AndroidFindBy(xpath="//*[@content-desc='9']")
	public WebElement content_desc_9;
	
	@AndroidFindBy(xpath="//*[@content-desc='15']")
	public WebElement content_desc_15;
	
	@AndroidFindBy(xpath="//*[@content-desc='45']")
	public WebElement content_desc_45;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Expandable Lists']")
	public WebElement ExpandableLists;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1. Custom Adapter']")
	public WebElement CustomAdapter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
	public WebElement draganddropbtn;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
	public  WebElement item1;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_2")
	public WebElement item2;
	
	
}
