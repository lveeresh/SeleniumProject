@OrangeHRMWebsite
Feature: OrangeHRM 




#we can also pass data using datatables- like below

@UsingDataTable_1  
Scenario: Successful login with valid credentials
   Given user launch the web browser
	
    When the user enters the following credentials     
	| username | password   |
	| veeresh  | Pass@1234  |
	| user1    | Test@5678  |
	| user2    | Hello@999  |
	| user3    | Welcome@321|
#    Then user navigate to homepage




