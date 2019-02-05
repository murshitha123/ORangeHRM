package com.hcl.orangeHRM.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.orangeHRM.qa.base.TestBase;
import com.hcl.orangeHRM.qa.pages.Homepage;
import com.hcl.orangeHRM.qa.pages.LoginPage;
import com.hcl.orangeHRM.qa.util.TestUtil;

public class HomeOrangeCRMTest extends TestBase{
	
	Logger log = Logger.getLogger(HomeOrangeCRMTest.class);
	String sheetname="AddUser";
	Homepage hpage;
	LoginPage lpg;

	public HomeOrangeCRMTest()
	{
		super();
	}
	
@BeforeMethod
	
	public void setup()
	{
		log.info("******** Starting Adduser Test Cases ***************");
		hpage=new Homepage();
		lpg=new LoginPage();
		hpage=lpg.validateLoginButton();
		System.out.println("Logged into the application successfully");
		
	}
	
	@DataProvider
	public Object[][]getAddUserData()
	{
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	
	@Test(priority=1,dataProvider="getAddUserData")
	public void verifyAddUsers(String EmployeeName, String Username, String ESSRole, String Supervisorrole,
			String adminrole, String status, String Password, String ConfirmedPassword, String Region,
			String Location)
	{
		Assert.assertTrue(hpage.validateAdduserpopuptitle());
		hpage.validateAddinguser(EmployeeName, Username, ESSRole, Supervisorrole, adminrole, status, Password, ConfirmedPassword, Region, Location);
		
		
				
	}
	
	@AfterMethod

	public void endsetup()
	{
		log.info("******** Finshed Executing the Test Case ***************");
	}

}
