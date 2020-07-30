package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoCode {
	public WebDriver driver;

	public RepoCode(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'creating a new file')]")
	public WebElement createNewFile;
	@FindBy(css = "input[type='text'][name='filename']")
	public WebElement fileName;
	@FindBy(css = "button[type='submit'][data-edit-text='Commit new file']")
	public WebElement commitButton;
	

}
