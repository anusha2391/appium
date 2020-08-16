package Appium_Base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public  abstract class Base 
 {
	
	 public static AndroidDriver<MobileElement> d;
	    public WebDriverWait wait;
	  
	    
	    public static AppiumDriverLocalService service;
		  public static AndroidDriver<AndroidElement>  driver;
		
		  
		public static AppiumDriverLocalService startServer()
		{
			//
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
			return service;
			
		}
		
	public static boolean checkIfServerIsRunnning(int port) {
			
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				
				serverSocket.close();
			} catch (IOException e) {
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}

	public static AndroidDriver<MobileElement> capabilities(String appName,String devicename,String platformName,String platformVersion) throws IOException 
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Appium_Base\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String deviceName=(String) prop.get(devicename);
		String platforname=(String) prop.get(platformName);
		String platformversion=(String) prop.get(platformVersion);
		System.out.println(deviceName+"||"+platforname+"||"+platformversion);
		
		File Appdie= new File("src");
       // File app= new File(Appdie, "ApiDemos-debug.apk");
     
       File app= new File(Appdie, (String) prop.get(appName));
        
        DesiredCapabilities ds= new DesiredCapabilities();
        
        /* ds.setCapability("devicename", "a7321a0a0606");
         ds.setCapability("platformName", "Android");
         ds.setCapability("platformVersion", "9");*/
        
         ds.setCapability("devicename",deviceName );
         ds.setCapability("platformName", platforname);
         ds.setCapability("platformVersion", platformversion);
         //ds.setCapability("noReset", true);
         ds.setCapability("app", app.getAbsolutePath());
    
        // ds.setCapability("automationName", "UiAutomator2");
        //ds.setCapability("appPackage", "in.amazon.mShop.android.shopping");
         //ds.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity")
         
         
         
         
         
         
        
         d=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),ds);
   WebDriverWait wait= new WebDriverWait(d,30);
     
    return d;
     
    
	}

	public static void getScreenshot(String name) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\screenshots\\"+name+".png"));
	
	}
}