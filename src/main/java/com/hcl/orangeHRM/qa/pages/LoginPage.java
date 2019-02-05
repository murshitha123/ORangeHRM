package com.hcl.orangeHRM.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Listeners;
import com.hcl.orangeHRM.qa.base.TestBase;




public class LoginPage extends TestBase{

	Logger log = Logger.getLogger(LoginPage.class);
	@FindBy(xpath="//img[@src='/webres_5bb766c11f7350.65475934/themes/default/images/login/logo.png']")
	WebElement Logo;
	@FindBy(name="txtUsername")
	WebElement UName;
	@FindBy(name="txtPassword")
	WebElement Pword;
	@FindBy(name="Submit")
	WebElement Lgnbtn;
	
	public LoginPage()

	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
		public String validateLoginPageTitle(){
			log.debug("Getting the title of the page");
			return driver.getTitle();
		}
		
		public boolean validateHRMImage(){
			log.debug("checking if the user logo is displayed or not");
			return Logo.isDisplayed();
		}
		
		public Homepage validateLoginButton()
		{
			UName.sendKeys(prop.getProperty("username"));
			log.debug("User name is entered");
			Pword.sendKeys(prop.getProperty("password"));
			log.debug("Password is entered");
			Lgnbtn.click();
			log.debug("submit button is clicked");
			return new Homepage();
			
		}

}