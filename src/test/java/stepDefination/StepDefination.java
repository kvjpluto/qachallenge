package stepDefination;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.naming.Context;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Common;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LoginPage;
import pageObjects.ManageRepository;
import pageObjects.RepoCode;
import pageObjects.RepoIssues;
import pageObjects.RepoSettings;

@RunWith(Cucumber.class)
public class StepDefination extends Common{
	ManageRepository mr=null;
	RepoIssues ri=null;
	RepoSettings rs=null;
	RepoCode rc=null;
	
	@When("User is loggedIn with {string} and {string}")
	public void user_is_loggedIn_with_and(String userid, String password) throws IOException, ParseException {
		driver=initializeDriver();
		driver.get(getGlobalProperties("siteUrl").toString());	
		LoginPage lp=new LoginPage(driver);
		lp.Signin.click();
		lp.userid.sendKeys(userid);
		lp.password.sendKeys(password);
		lp.submit.click();
	}
	
	@When("User creates repository {string} {string}")
	public void user_creates_repository(String name, String access) throws InterruptedException {
		mr=new ManageRepository(driver);
		waitElement(mr.createNew);
		mr.createNew.click();
		mr.repositoryName.sendKeys(name);
		if(mr.duplicateNameError.isDisplayed()) {
			mr.repositoryName.clear();
			mr.repositoryName.sendKeys(name+System.currentTimeMillis());
		}
		if(access.equalsIgnoreCase("private")) {
			mr.privateVisibility.click();
		}
		else {
			mr.publicVisibility.click();
		}
		waitElement(mr.createRepository);
		mr.createRepository.click();
	}
	@Then("Repository is successfully created")
	public void repository_is_successfully_created() {
	 
	}

	@When("User creates issue in {string} {string}")
	public void user_creates_issue_in(String value,String desc) {
		   ri=new RepoIssues(driver);
		   ri.issues.click();
		   ri.newIssue.click();
		   ri.issueTitle.sendKeys(value);
		   ri.issueBody.sendKeys(desc);
		   ri.submitIssue.click();
	}

	@Then("User can create multiple issues")
	public void user_can_create_multiple_issues() {
		String issueTitle=ri.getIssueTitle.getText();
		String issueDesc=ri.issueDescription.getText();
		waitElement(ri.multipleIssues);
		ri.multipleIssues.click();
		ri.issueTitle.sendKeys(issueTitle);
		ri.issueBody.sendKeys(issueDesc);
		ri.submitIssue.click();
	}

@Then("User can add emoji in repository")
public void user_can_add_emoji_in_repository() {
	rc=new RepoCode(driver);
	mr.repoCode.click();
	rc.createNewFile.click();
	rc.fileName.sendKeys("testFile");
	rc.commitButton.click();
	ri.editRepoDesc.click();
	ri.repoDesc.sendKeys(":bowtie:");
	ri.saveRepoChanges.click();
}
@Then("User can link comments to issue {string}")
public void user_can_link_comments_to_issue(String string) {
	ri.issues.click();
	ri.issuesList.get(0).click();
	ri.newComment.clear();
	ri.newComment.sendKeys(string+" #");
	String issue=ri.openIssues.getText();
	ri.openIssues.click();
	ri.submitComment.click();
	String[] issueArray=issue.split(" ");
	for(WebElement issueLink:ri.issueLinks) {
		if(issueArray[0].equalsIgnoreCase(issueLink.getText())) {
			issueLink.click();
		}
	}
}
	@Then("User can add comment {string}")
	public void user_can_add_comment(String string) throws InterruptedException {
		ri.newComment.sendKeys(string);
		ri.submitComment.click();
	}
	
	@Then("User can delete repository")
	public void user_can_delete_repository() {
		rs=new RepoSettings(driver);
		rs.settings.click();
		if(scrollView(driver, rs.deleteRepo))
			rs.deleteRepo.click();
		waitElement(rs.repoName);
		rs.deleteConfirmation.sendKeys(rs.repoName.getText());
		rs.deleteButton.click();
	}
	
}
