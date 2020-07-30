package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='/login']")
	public WebElement Signin;
	@FindBy(id = "login_field")
	public WebElement userid;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(css = "input[type='submit'][name='commit']")
	public WebElement submit;
	

}
