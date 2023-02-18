package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;

public class FirstTest extends BaseClass {
@Test
	public void firstTest() {
		SoftAssert soft = new SoftAssert();
		home.clickGears();
		home.clickSkillrarydemoApp();
		web.handleChildBrowser();
		skillraryDemo.mouseHoverToCourse(web);
		skillraryDemo.clickSeleniumTraining();
		selenium.doubleClickPlusBUtton(web);
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		selenium.doubleClickPlusBUtton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		web.explicitwait(time, selenium.getItemAddedMesage());
		web.takeScreenshot();
		soft.assertTrue(selenium.getItemAddedMesage().isDisplayed());
		
		soft.assertAll();
		
	}

}
