package Utilities;

import java.io.IOException;

public class HelloWorld {

	public static void main(String[] args) throws IOException 
	{
		String filepathString="./test-data/LoginTestData.xlsx";
		int rowno=ExcelUtil.getRowCount(filepathString, "Sheet1");
		System.out.println("rows ---->"+rowno);
		int colcount=ExcelUtil.getColumnCount(filepathString, "Sheet1");
		System.out.println("columns ---->"+colcount);
		System.out.println("--->"+ExcelUtil.getCellData(filepathString, "Sheet1", 1, 2));
		
	}

}
