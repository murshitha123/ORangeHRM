package com.hcl.orangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.orangeHRM.qa.base.TestBase;
import com.hcl.orangeHRM.qa.util.TestUtil;

public class Homepage extends TestBase{
	
	@FindBy(xpath="//li[text()='Dashboard']")
	WebElement HomePageTitle;
	
	@FindBy(xpath="//span[@class='left-menu-title' and text()='Admin']")
	WebElement AdminCollapsebutton;
	
	@FindBy(xpath="//span[contains(text(),'User Management')]")
	WebElement UserMangementCollapsebutton;
	
	@FindBy(xpath="//span[@class='left-menu-title' and text()='Users']")
	WebElement UsersLbl;

	@FindBy(xpath="//i[contains(text(),'add')]")
	WebElement AddUserbtn;
	
	@FindBy(xpath="//h4[contains(text(),'Add User')]")
	WebElement AdduserLbl;
	
	@FindBy(xpath="//input[@id='selectedEmployee_value']")
	WebElement Ename;
	
	@FindBy(xpath="//input[@id='user_name']")
	WebElement Uname;
	
	@FindBy(xpath="//div[@class='select-wrapper initialized']/input[@value='-- Select --']/following-sibling::ul[@class='dropdown-content select-dropdown']/li/span[contains(text(),'-- Select --')]")
	WebElement EssRoleDropdown;
	
	@FindBy(xpath="//div[@class='select-wrapper initialized']/input[@value='Default Supervisor']/following-sibling::ul[@class='dropdown-content select-dropdown']/li/span[contains(text(),'-- Select --')]")
	WebElement Supervisorroledropdw;
	
	@FindBy(xpath="//input[@class='select-dropdown' and @value='-- Select --']")
	WebElement AdminRoledropdwn;
	
	@FindBy(xpath="//input[@class='select-dropdown' and @value='Enabled']")
	WebElement Statusdropdw ;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Passwordtxtbox;
	
	@FindBy(xpath="//input[@id='confirmpassword']")
	WebElement ConfirmPasswordtxtbox;
	
	@FindBy(xpath="//a[@id='systemUserSaveBtn']")
	WebElement Savebtn;
	
	@FindBy(xpath="//h4[contains(text(),'Modify Region')]")
	WebElement ModifyRegionTxt;
	
	@FindBy(xpath="//label[@for='allRegions']")
	WebElement AllRegionscheckbox;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement SelectRegiondropdown;
	
	
	@FindBy(xpath="//label[@for='selectedLocationsOnly_CA']")
	WebElement SelectLocationcheckbox;
	
	@FindBy(xpath="//div[@class='input-field col s5']//autocomplete-multiple[@class='ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form']//div[@class='multyselect-autocomplete-holder']//div//input[@placeholder='Type for hints...']")
	WebElement Locationdropdown;
	public  Homepage()
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Actions
	public boolean homePageTextValidation()
	{
		boolean HomePageActualText=HomePageTitle.isDisplayed();
		return HomePageActualText;
	}
	
	
	public boolean validateAdduserpopuptitle()
	{
		TestUtil.buttonClick(AdminCollapsebutton);
		TestUtil.buttonClick(UserMangementCollapsebutton);
		TestUtil.buttonClick(UsersLbl);
		TestUtil.buttonClick(AddUserbtn);
	    boolean adduserpopuplabel= AdduserLbl.isDisplayed();
		return adduserpopuplabel;
	}
	
	
	public void validateAddinguser(String EmployeeName, String Username, String ESSRole, String Supervisorrole,
			String adminrole, String status, String Password, String ConfirmedPassword, String Region,
			String Location) {
		TestUtil.enterText(Ename, EmployeeName);
		TestUtil.enterText(Uname, Username);
		EssRoleDropdown.click();
		EssRoleDropdown.sendKeys(ESSRole);
		TestUtil.selectdropdown(Supervisorroledropdw, Supervisorrole);
		TestUtil.selectdropdown(AdminRoledropdwn, adminrole);
		TestUtil.selectdropdown(Statusdropdw, status);
		TestUtil.enterText(Passwordtxtbox, Password);
		TestUtil.enterText(ConfirmPasswordtxtbox, ConfirmedPassword);
		TestUtil.buttonClick(Savebtn);
		if (ModifyRegionTxt.isDisplayed()) {
			TestUtil.checkBoxSelection(AllRegionscheckbox);
		} else {
			System.out.println("ModifyRegionpopup is not displayed");
		}
		TestUtil.selectdropdown(SelectRegiondropdown, Region);
		TestUtil.checkBoxSelection(SelectLocationcheckbox);
		TestUtil.selectdropdown(Locationdropdown, Location);
		

	}
}
