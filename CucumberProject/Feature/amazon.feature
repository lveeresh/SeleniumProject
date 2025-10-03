@OrangeHRMWebsite
Feature: OrangeHRM 

#Background:
#Given user launch the web browser
#When user open the application URL

#-->Background keyword is used to define common steps that should run before each scenario in the same feature file.
# no need to use these steps again in scenario level
#  OrderOfExecution-->@Before--> Background--> Scenario--> @After

@SucessfulLogin
Scenario: Validate successful login feature 

Given user launch the web browser
When user open the application URL
When user entered valid userid and password
And user click on sign in button
Then user navigate to homepage


@UnSuccessfulLogin
Scenario Outline: Validate error messages for inavalid sign in credentials

Given user launch the web browser
When user open the application URL
When user enters the invalid  "<username>"
And user enters the invalid "<password>"
And user click on sign in button
Then user will get the error message for invalid sign in "<username>" and "<password>"
Examples:
|username|password |
|123456yt|12345678 |
|@@@@@##$|???????? |


#we can also pass data using datatables- like below

@UsingDataTable_1  
Scenario: Successful login with valid credentials
   Given user launch the web browser
	When user open the application URL
    When the user enters the following credentials     
	| username | password   |
	| veeresh  | Pass@1234  |
	| user1    | Test@5678  |
	| user2    | Hello@999  |
	| user3    | Welcome@321|
#    Then user navigate to homepage

@UsingDataTable_2 @Skip
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username and password
      | veeresh  | Pass@1234 |
    Then user navigate to homepage



