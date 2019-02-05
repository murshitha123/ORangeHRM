package com.hcl.orangeHRM.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hcl.orangeHRM.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Murshi\\eclipse-workspace\\OrangeHRM\\src\\main\\java\\com\\hcl\\orangeHRM\\qa\\testdata\\OrangeHRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static String datearr[];
	public static String day;
	public static String month;
	public static String year;

	public void dateSplitfunction(String Calenderdate) {
		String datearr[] = Calenderdate.split("/");
		day = datearr[0];
		month = datearr[1];
		year = datearr[2];
	}

	
	public static void selectdropdown(WebElement we,String text)
	{
		Select dropdown=new Select(we);
		dropdown.selectByVisibleText(text);
	}
	
	public static void enterText(WebElement we,String text)
	{
		we.sendKeys(text);
	}
	
	public static void buttonClick(WebElement we)
	{
		we.click();
	}
	
	public static void checkBoxSelection(WebElement we)
	{
		if(we.isSelected())
		{
			we.click();
		}
		else
		{
			we.click();

		}
	}
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void selectDateByJsScript(WebDriver driver, WebElement element, String dateval) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateval + "');", element);
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static String getTimeStamp() {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    return timestamp;
	}
	public static void takeScreenshotAtEndOfTest(String testMethodName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +getTimeStamp() + ".png"));
		
		FileUtils.copyFile(scrFile,new File(currentDir + "/screenshots/"+"failshot_"+testMethodName+getTimeStamp()+"_"+".jpg"));
	}
}

