package testpylotpckg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilityclass {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path= null;

 	Utilityclass(String path)
 	{
 		this.path= path;
 	}
 	
 	public int getRowCount(String sheetName) throws IOException
 	{
 		fi=new FileInputStream(path);
 		workbook= new XSSFWorkbook(fi);
 		sheet=workbook.getSheet(sheetName);
 		int rowcount=sheet.getLastRowNum();
 		workbook.close();
 		fi.close();
 		return rowcount;
 		
 	}
 	
 	public int getCellCount(String sheetName,int rownum) throws IOException
 	{
 		fi=new FileInputStream(path);
 		workbook= new XSSFWorkbook(fi);
 		sheet=workbook.getSheet(sheetName);
 		row=sheet.getRow(rownum);
 		int cellcount=row.getLastCellNum();
 		workbook.close();
 		fi.close();
 		return cellcount;
 	}
 	 
 	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
 	{
 		fi= new FileInputStream(path);
 		workbook= new XSSFWorkbook(fi);
 		sheet=workbook.getSheet(sheetName);
 		row=sheet.getRow(rownum);
 		cell=row.getCell(colnum);
 		
 		DataFormatter formatter=new DataFormatter();
 		String data;
 		try
 		{
 			data=formatter.formatCellValue(cell);
 			
 		}
 		catch(Exception e)
 		{
 			data="";
 		}
 		workbook.close();
 		fi.close();
 		return data;
 		}
 	
 	public void setCellData(String sheetname,int rownum,int colnum,String data) throws IOException
 	{
 		fi= new FileInputStream(path);
 		workbook= new XSSFWorkbook(fi);
 		sheet= workbook.getSheet(sheetname);
 		sheet.getRow(rownum).createCell(colnum).setCellValue(data);
 		/*row= sheet.getRow(rownum);
 		cell=row.createCell(colnum);
 		cell.setCellValue(data);*/
 		
 		fo= new FileOutputStream(new File(path));
 		workbook.write(fo);
 		workbook.close();
 		fi.close();
 		fo.close();
 	}
 	}
