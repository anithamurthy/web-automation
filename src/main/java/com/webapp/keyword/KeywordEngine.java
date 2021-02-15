package com.webapp.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.webapp.base.BaseClass;

public class KeywordEngine extends BaseClass {

	public static void driver(String sheetName) {

		KeywordExecute executor = new KeywordExecute();
		try {

			InputStream fis = new FileInputStream(prop.getProperty("keyword_data"));

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row;

			String keywordData, locatorData, inputData;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				keywordData = row.getCell(0, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
				locatorData = row.getCell(1, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
				inputData = row.getCell(2, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
				executor.execute(driver, keywordData, locatorData, inputData);
			}
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
