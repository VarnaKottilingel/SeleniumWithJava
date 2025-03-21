package com.github.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    // private XSSFWorkbook workbook;
     

    public static XSSFWorkbook getExcelWorkBook(String path) throws IOException {
		FileInputStream fs = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		return wb;
	}
		
	public static XSSFSheet getExcelWorkSheet(String path,String Sheetname) throws IOException {
		FileInputStream fs = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet ws = wb.getSheet(Sheetname);
        wb.close();
		return ws;
	}
       

}
