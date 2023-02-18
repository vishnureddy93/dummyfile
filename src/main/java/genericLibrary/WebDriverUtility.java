	package genericLibrary;



	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	/**
	 * This method contains all reusable methods of webdriver
	 * @author Admin
	 *
	 */
	public class WebDriverUtility {
		WebDriver driver;
		/**
		 * this method is used to launch the browser and fetch the url
		 * 
		 * @author Soundarya S P
		 * @param url
		 *
		 */
		public WebDriver openApplication(String browser, String url, long time) {
			switch(browser) {
			case "Chrome": driver = new ChromeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			case "edge": driver = new EdgeDriver();break;
			default: System.out.println("Invalid browser data");
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
			return driver;
		}
		/**
		 * This method is used to mouse hover on an element
		 * @param element
		 */
		public void mouseHover(WebElement element) {
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		}
		/**
		 * This method is used to doubleclick  on an element
		 * @param element
		 */
		public void doubleClickonElement(WebElement element) {
			Actions a = new Actions(driver);
			a.doubleClick(element).perform();
		}
		
		/**
		 * This method is used to drag & drop an element
		 * @param element
		 * @param index
		 */
		public void dropdown(WebElement element, int index) {
			Select s = new Select(element);
			s.selectByIndex(index);
		}
		/**
		 * This methos is used to select an element from drop down based on text 
		 * @param element
		 * @param value
		 */
	public void dropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
		}
	/**
	 * This method is used to switch to frame based on index 
	 */
	public void switchToFrame() {
		driver.switchTo().frame(0);
	}
	/**
	 * This methos is used to switch back from frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to handle alret by
	 */
	public void  handleAlert() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to child browser pop
	 */
	public void handleChildBrowser() {
		Set<String>windowIDs = driver.getWindowHandles();
		for (String string : windowIDs) {
			driver.switchTo().window(string);
		}
		}
	/**
	 * This method is used to get parent window id
	 */
	public void switchToParentwindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}
	/**
	 * This method used to scrool the page till web element
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoview(true)", element);
	}
	/**
	 * This method is used to fetch the screenshot based 
	 */
	public void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/picture.png");
		try {
			FileUtils.copyFile(src, dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to wait untill the visibility of web element
	 * @param time
	 * @param element
	 */
	public void explicitwait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to close the current window 
	 */
	public void closeCurrentwindow() {
		driver.close();
	}
	/**
	 * This method is used to close all the windows and exit browser
	 */
	public void quitBrowser() {
		driver.quit();
		}


	}


