package Appium_Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excellib 
{
	  
	public static String getData(String path,String fileName,String sheetname,int rownum,int colnum) throws IllegalFormatException, IOException, InvalidFormatException
	  {
		  String v="";
		  FileInputStream f=new FileInputStream(System.getProperty("user.dir")+path);
		  
		
		  Workbook Workbook = null;

		   

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		  
		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    Workbook = new XSSFWorkbook(f);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		        Workbook = new HSSFWorkbook(f);

		    }

		
		  v=Workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).toString();
		  return v;  
		  
	  }
	  public static int getRowCount(String path,String fileName,String sheet)
		{
			int rc=0;
			try
			{
				String v="";
				  FileInputStream f=new FileInputStream(System.getProperty("user.dir")+path);
				  
				  Workbook Workbook = null;

				   

				    String fileExtensionName = fileName.substring(fileName.indexOf("."));

				  
				    if(fileExtensionName.equals(".xlsx")){

				    //If it is xlsx file then create object of XSSFWorkbook class

				    Workbook = new XSSFWorkbook(f);

				    }

				    //Check condition if the file is xls file

				    else if(fileExtensionName.equals(".xls")){

				        //If it is xls file then create object of HSSFWorkbook class

				        Workbook = new HSSFWorkbook(f);

				    }

				
				rc=Workbook.getSheet(sheet).getLastRowNum();
				
			}
			catch(Exception e){
						
			}		
			return rc;		
		}

	  public static int getintExcelData1(String path,String fileName,String sheetname,int rownum,int colnum) throws InvalidFormatException {
			// TODO Auto-generated method stub
			int retVal=0;
			try {
				 FileInputStream f=new FileInputStream(System.getProperty("user.dir")+path);
				  
				  Workbook Workbook = null;

				   

				    String fileExtensionName = fileName.substring(fileName.indexOf("."));

				  
				    if(fileExtensionName.equals(".xlsx")){

				    //If it is xlsx file then create object of XSSFWorkbook class

				    Workbook = new XSSFWorkbook(f);

				    }

				    //Check condition if the file is xls file

				    else if(fileExtensionName.equals(".xls")){

				        //If it is xls file then create object of HSSFWorkbook class

				        Workbook = new HSSFWorkbook(f);

				    }
				
				Sheet s=Workbook.getSheet(sheetname);
				Row r=s.getRow(rownum);
				Cell c=r.getCell(colnum);
				retVal=(int)c.getNumericCellValue();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return retVal;

		}	
		
	  public static long getintExcelData2(String path,String fileName,String sheetname,int rownum,int colnum) throws IllegalFormatException {
			// TODO Auto-generated method stub
			long retVal=0;
			try {
				 FileInputStream f=new FileInputStream(System.getProperty("user.dir")+path);
				  
				  Workbook Workbook = null;

				   

				    String fileExtensionName = fileName.substring(fileName.indexOf("."));

				  
				    if(fileExtensionName.equals(".xlsx")){

				    //If it is xlsx file then create object of XSSFWorkbook class

				    Workbook = new XSSFWorkbook(f);

				    }

				    //Check condition if the file is xls file

				    else if(fileExtensionName.equals(".xls")){

				        //If it is xls file then create object of HSSFWorkbook class

				        Workbook = new HSSFWorkbook(f);

				    }

				Sheet s=Workbook.getSheet(sheetname);
				Row r=s.getRow(rownum);
				Cell c=r.getCell(colnum);
				retVal=(long)c.getNumericCellValue();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return retVal;

		}

}
