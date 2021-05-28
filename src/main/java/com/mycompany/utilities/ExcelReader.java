package com.mycompany.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	static XSSFSheet ws;
	static XSSFWorkbook wb;
	static XSSFCell cell;
	static XSSFRow row;

	public static void main(String[] args) throws Exception
	{
		File file1 = new File ("C:\\Users\\mnprt\\eclipse-workspace\\CucumberDD\\src\\main\\resources\\test_data\\td.xlsx");

		FileInputStream is =new FileInputStream(file1);

		wb = new XSSFWorkbook(is);  

		ws = wb.getSheetAt(0);


		Iterator<Row> rowIterator = ws.iterator();

		while (rowIterator.hasNext()) 
		{ 
			row  = (XSSFRow) rowIterator.next(); 
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) 
			{
				Cell cell  = cellIterator.next();

				switch (cell.getCellType()) 
				{
				case NUMERIC:
					System.out.print(cell.getNumericCellValue() + "(Integer)\t");
					break;
				case STRING:
					System.out.print(cell.getStringCellValue() + "(String)\t");
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue()+"(Boolean)\t");
				default:
					break;
				}
			}
			System.out.println("");
		}
	} 

}


