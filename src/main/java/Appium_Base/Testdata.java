package Appium_Base;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testdata 
{
	
   public static Excellib excellib=null;
   String path="./Testdata.xlsx";
	@DataProvider(name="inputdata")
	public Object[][]  getdataforNamefield()
	{
		Object[][] d=new Object[][]
				{
			     {"anusha"},{"@anusha"}
				} ;
		return d;
		
	}
	
	@DataProvider(name="getdata")
	public Object[][]  getdata()
	{
		Object[][] d=new Object[2][3];
		
				
		return d;
		
	}
	
 @Test
 public void testdata(String username,String country)
 {
	 
 }

}
