package com.hcl.orangeHRM.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hcl.orangeHRM.qa.base.TestBase;
import com.hcl.orangeHRM.qa.util.CustomListener;
import com.hcl.orangeHRM.qa.pages.Homepage;
import com.hcl.orangeHRM.qa.pages.LoginPage;


@Listeners(CustomListener.class)
public class LoginOrangeHRMTest extends TestBase {
	
Logger log = Logger.getLogger(LoginOrangeHRMTest.class);
	LoginPage lpg;
	Homepage hpg;
	public LoginOrangeHRMTest() {
		super();
	}
	
	
	@BeforeMethod
	
	public void setup()
	{
		log.info("******** Starting Login Class Test Cases ***************");
		lpg=new LoginPage();
		
	}
	
	@Test(priority = 1)
	
	public void loginPageTitleTest()
	{  	log.info("******** Starting loginPageTitleTest Test Case ***************");
		try
		{
			String actualTitle=lpg.validateLoginPageTitle();
			Assert.assertEquals(actualTitle, "OrangeHRM");
		}
		catch(Exception e)
		{
			log.error("An exception! Oops!", e);
		}
		log.info("******** Ending loginPageTitleTest Test Case  ***************");
	}
	
@Test(priority = 2)
	
	public void loginPageLogoTest()
	{
	log.info("******** Starting loginPageLogoTest Test Case ***************");
		try
		{
			
	    Assert.assertTrue(lpg.validateHRMImage());
	    System.out.println("Logo is displayed in the LoginPage");
		}
		catch(Exception e)
		{
			log.error("An exception! Oops!", e);
		}
	    log.info("******** Ending loginPageLogoTest Test Case  ***************");
		
			
			
		
		
		
	}
	
@Test(priority = 3)
public void verifyLoginfunction() 
{
	log.info("******** Starting verifyLoginfunctiont Test Case ***************");
	
	try
	{
		hpg=lpg.validateLoginButton();
	
	Assert.assertTrue(hpg.homePageTextValidation());
	System.out.println("User is successfullly logged into the application");
	}
	catch(Exception e)
	{
		log.error("An exception! Oops!", e);
	}
		
	log.info("******** Ending verifyLoginfunctiont Test Case  ***************");
}


@AfterMethod

public void endsetup()
{
	log.info("******** Finshed Executing the Test Case ***************");
}

}
