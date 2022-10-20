package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil 
{
	public static XSSFWorkbook workbook;	
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream inputStream;
	
	public static int getRowCount(String fileLocation, String sheetname) throws IOException
	{
		inputStream=new FileInputStream(fileLocation);
		workbook=new XSSFWorkbook(inputStream);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		return rowcount+1;
		
	}
	public static int getColumnCount(String fileLocation, String sheetname) throws IOException
	{
		inputStream=new FileInputStream(fileLocation);
		workbook=new XSSFWorkbook(inputStream);
		sheet=workbook.getSheet(sheetname);
		int colcount=sheet.getRow(0).getLastCellNum();
		return colcount;
		
	}
	public static String getCellData(String filepath, String sheetname,int rowNo, int colNo ) throws IOException
	{
		inputStream=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(inputStream);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rowNo);
		//String valueString=row.getCell(colNo).getStringCellValue();
	
		try {
			return  row.getCell(colNo).getStringCellValue();
		} catch (Exception e) {
			return "";
		}
		
		
		
//		if(row.getCell(colNo).getStringCellValue()==null)
//		{
//			return "";
//		}
//		else {
//			return row.getCell(colNo).getStringCellValue();
//		}
		
	}
	
	
}
