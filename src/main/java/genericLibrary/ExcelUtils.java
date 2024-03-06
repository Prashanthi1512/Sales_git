package genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public String readDataFromExcel(String Sheetname, int row, int cel) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		String value = sh.getRow(row).getCell(cel).getStringCellValue();
		return value;
		
	}
	public int getLastrowno(String Sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		int rowno=sh.getLastRowNum();
		return rowno;
		
	}

	public void writeDataIntoExcel(String Sheetname,int row,int cell, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		sh.getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(IpathConstants.excelpath);
		book.write(fout);
		book.close();
		
	}
	public HashMap<String, String> readMultipleDataFromExcel(String Sheetname,int cel) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		int rowcount=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String,String>();
		for(int i=0;i<=rowcount;i++)
		{
			String key = sh.getRow(i).getCell(cel).getStringCellValue();
			String value = sh.getRow(i).getCell(cel+1).getStringCellValue();
			map.put(key, value);
			
		}
		return map;
		
	
	}
	
	public Object[][] dataProviderExcel(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
			
		return obj;	
			
		
	}
	public Object[][] dataProviderFacebook(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\SalesData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheet);
		int lastrow=sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastrow][lastcell];	
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
}
