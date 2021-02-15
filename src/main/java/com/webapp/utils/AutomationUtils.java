package com.webapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.webapp.base.BaseClass;

public class AutomationUtils extends BaseClass {

	public static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss");
	static Workbook book;
	static Sheet sheet;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static String getFormattedTimeStamp() {
		return SIMPLE_DATE_FORMAT.format(new Date());
	}

	public static void takeScreenshot(String sTestCaseName) throws Exception {

		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshots/" + sTestCaseName + "_"
					+ System.currentTimeMillis() + ".jpg"));

		} catch (Exception e) {

			Logging.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());

			throw new Exception();

		}

	}

	public static Object[][] readExcelData(String sheetName) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(prop.getProperty("test_data"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {

			book = WorkbookFactory.create(fis);

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				if ((sheet.getRow(i).getCell(j)) != null) {
					testData[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}

		}
		return testData;
	}

}
