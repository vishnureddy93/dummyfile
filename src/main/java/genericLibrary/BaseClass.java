package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.CoreJavaForSeleniumPage;
import pompages.Homepage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;
import pompages.contactUsPage;
import pompages.corejavaVideoPage;
import pompages.seleniumTrainingPage;

public class BaseClass {

	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected Homepage home;
	protected long time;
	protected SkillraryDemoAppPage skillraryDemo;
	protected contactUsPage contact;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected seleniumTrainingPage selenium;
	protected corejavaVideoPage javaVideo;
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	       public void classConfiguration()
	       {
		     property= new PropertiesFileUtility();
		     excel= new ExcelUtility();
		    
			 web= new WebDriverUtility();
		
		     
		     property.propertyFileInitialization(Iconstantpath.PROPERTIES_FILE_PATH);
		     excel.excelInitialization(Iconstantpath.EXCEL_FILE_PATH);
		     
	       }

	@BeforeMethod
	public void methodConfiguration() {
		time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		home=new Homepage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		skillraryDemo = new SkillraryDemoAppPage(driver);
		selenium= new seleniumTrainingPage(driver);
		coreJava=new CoreJavaForSeleniumPage(driver);
		javaVideo= new corejavaVideoPage(driver);
		testing=new TestingPage(driver);
		contact=new contactUsPage(driver);
	}

	@AfterMethod
	    public void methodTearDown()
	    {
		   web.quitBrowser();
	    }
	@AfterClass
	     public void classTearDown()
	     {
		   excel.closeExcel();
	     }
       	
	// @AfterTest
	// @AfterSuite
}
