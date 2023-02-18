package pompages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverUtility;

public class seleniumTrainingPage {
//Declaration
	
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id="add")
	private WebElement plusButton;
	
	@FindBy(xpath="//button[text()=' Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//div[@id='callout']/span")
	private WebElement ItemAddedMessage;
	
	//Initialization
	public seleniumTrainingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getPageHeader()
	{
		return pageHeader;
	}
	
	public void doubleClickPlusBUtton(WebDriverUtility web)
	{
		web.doubleClickonElement(plusButton);
	}
	
	public void clickAddToCart()
	{
		addToCartButton.click();
	}
	
	public WebElement getItemAddedMesage()
	{
		return ItemAddedMessage;
	}
}
