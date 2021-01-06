package Automation.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReader 
{
	
	public static ArrayList<Object[]> getDataFromExcel() throws IOException 
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		String projectpath = System.getProperty("user.dir");
		File file=new File(projectpath+"\\Inputs.xlsx");
		FileInputStream str=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(str);
		XSSFSheet sh=wb.getSheetAt(1);
		
		int i=0;
		String name = null,lname= null,email= null,pass= null,cpass= null;
		int cnt=sh.getLastRowNum();
		
		while(i<=cnt)
		{
			
			name=sh.getRow(i).getCell(0).getStringCellValue();
			lname=sh.getRow(i).getCell(1).getStringCellValue();
			email=sh.getRow(i).getCell(2).getStringCellValue();
			pass=sh.getRow(i).getCell(3).getStringCellValue();
			cpass=sh.getRow(i).getCell(4).getStringCellValue();
			Object ob[]= {name,lname,email,pass,cpass};
			myData.add(ob);
			i++;
			
		}
		wb.close();
		return myData;
		
	}
}
