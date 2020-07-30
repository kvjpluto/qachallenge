Feature: Git Hub Challenges

Background: User is LoggedIn
	When User is loggedIn with "YourUserName" and "YourPassword"
	
Scenario Outline: Verify Repository is successfully created
	When User creates repository "<repository_name>" "<access>"
	Then Repository is successfully created
	And User creates issue in "<issue_title>" "<issue_desc>"
	And User can create multiple issues
	And User can add comment "<comment>"
	And User can add emoji in repository
	And User can link comments to issue "<comment>"
	And User can delete repository
	
Examples:
	|repository_name	|access	|issue_title	|issue_desc|comment	|
	|test				|public	|test			|testing	|comment on issue|
