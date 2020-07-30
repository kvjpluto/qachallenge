package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageRepository {
	public WebDriver driver;

	public ManageRepository(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[data-ga-click*='Dashboard'][href='/new']")
	public WebElement createNew;
	@FindBy(id = "repository_name")
	public WebElement repositoryName;
	@FindBy(id = "repository_description")
	public WebElement repositoryDesc;
	@FindBy(css = "dd[id*='input-check'][class='error']")
	public WebElement duplicateNameError;
	@FindBy(id = "repository_visibility_public")
	public WebElement publicVisibility;
	@FindBy(id = "repository_visibility_private")
	public WebElement privateVisibility;
	@FindBy(css = "button[type='submit'][data-disable-with*='Creating repository']")
	public WebElement createRepository;
	@FindBy(css = "span[data-content='Code']")
	public WebElement repoCode;

}
