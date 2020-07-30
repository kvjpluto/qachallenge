package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	public static WebDriver driver;
	static boolean elementvisible = false;

	public static String getGlobalProperties(String value) throws IOException {
		Properties property=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties");
		property.load(fis);
		return property.getProperty(value);
	}
	public WebDriver initializeDriver() throws IOException, ParseException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+getGlobalProperties("driverPath"));
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver; 
	}
	public static boolean scrollView(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int height=driver.manage().window().getSize().height;
		while(!elementvisible) {
			js.executeScript("window.scrollBy(0,"+height/2+")");
			if(element.isDisplayed()) {
				elementvisible=true;
			}
		}
		return elementvisible; 
	}
	public static void waitElement(WebElement element) {
		 WebDriverWait wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
