package pompages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	//Declaration
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(name="q")
	private WebElement searchTF;
	
	@FindBy(xpath="//input[@value='go']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/li[7]")
	private WebElement demoApplink;
	
	
	//Initialization
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getLogo() {
		return logo;
	}
	
	public void searchFor(String data)
	{
		searchTF.sendKeys(data);
		searchButton.click();
	}
	
	public void clickGears()
	{
		gearsTab.click();
	}
	public void clickSkillrarydemoApp()
	{
		demoApplink.click();
	}
}
