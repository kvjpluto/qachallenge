package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoSettings {
	public WebDriver driver;

	public RepoSettings(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "span[data-content='Settings']")
	public WebElement settings;
	@FindBy(xpath = "//summary[contains(text(),'Delete this repository')]")
	public WebElement deleteRepo;
	@FindBy(xpath = "//details-dialog[@aria-label='Delete repository']//p//strong[2]")
	public WebElement repoName;
	@FindBy(xpath = "//input[contains(@aria-label,'confirm that you want to delete')]")
	public WebElement deleteConfirmation;
	@FindBy(xpath = "//button[contains(text(),'delete this repository')]")
	public WebElement deleteButton;

}
