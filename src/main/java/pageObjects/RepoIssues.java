package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoIssues {
	public WebDriver driver;

	public RepoIssues(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span[data-content='Issues']")
	public WebElement issues;
	@FindBy(xpath = "//span[contains(text(),'New issue')]")
	public WebElement newIssue;
	@FindBy(id = "issue_title")
	public WebElement issueTitle;
	@FindBy(id = "issue_body")
	public WebElement issueBody;
	@FindBy(xpath = "//button[contains(text(),'Submit new issue')]")
	public WebElement submitIssue;
	@FindBy(xpath = "//a[contains(text(),'New issue') and contains(@data-ga-click,'Issues')]")
	public WebElement multipleIssues;
	@FindBy(css = "span[class='js-issue-title']")
	public WebElement getIssueTitle;
	@FindBy(css = "div[class='edit-comment-hide'] p")
	public WebElement issueDescription;
	@FindBy(xpath = "//ul[contains(@id,'text-expander')]/li")
	public WebElement openIssues;
	@FindBy(xpath = "//a[@class='issue-link js-issue-link']")
	public  List<WebElement> issueLinks;
	@FindBy(id = "new_comment_field")
	public WebElement newComment;
	@FindBy(xpath = "//button[contains(text(),'Comment')]")
	public WebElement submitComment;
	@FindBy(css = "svg[class='octicon octicon-gear float-right']")
	public WebElement editRepoDesc;
	@FindBy(id = "repo_description")
	public WebElement repoDesc;
	@FindBy(xpath = "//button[contains(text(),'Save changes')]")
	public WebElement saveRepoChanges;
	@FindBy(css = "a[id*='issue']")
	public List<WebElement> issuesList;

}
