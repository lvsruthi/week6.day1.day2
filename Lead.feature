Feature: Lead Functionality - CREATE, DUPLICATE, EDIT, MERGE and DELETE


//Background: 
//Given Launch the Browser 
//And Load the application url "http://leaftaps.com/opentaps/"

@Regression
Scenario Outline: TC001_Create Lead - Multiple Value

Given Enter username as <Username>
And Enter the password as <Password>
And click on Login Button
And Homepage should be displayed
And Click on LinkText "CRM/SFA"
And Click on LinkText "Leads"
And Click on LinkText "Create Lead"
And Enter CompanyName as Temenos
And Enter FirstName as Sru
And Enter LastName as Pri
When Submit button is clicked
Then Verify Lead is created
	
Examples:
|Username|Password|
|'Demosalesmanager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

@Smoke
Scenario: TC002_Duplicate Lead

Given Enter username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And click on Login Button
And Homepage should be displayed
And Click on LinkText "CRM/SFA"
And Click on LinkText "Leads"
And Click on LinkText "Find Leads"
And Click on the Phone Tabs
And Enter phoneNumber as '99'
And click on the FindLeads Button
And click on the First Result
And Click on LinkText "Duplicate Lead"
When Submit button is clicked
Then Verify Lead is Duplicated
	
		
@Functional
Scenario: TC003_Edit Lead

Given Enter username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And click on Login Button
And Homepage should be displayed
And Click on LinkText "CRM/SFA"
And Click on LinkText "Leads"
And Click on LinkText "Find Leads"
And Click on the Phone Tabs
And Enter phoneNumber as '99'
And click on the FindLeads Button
And click on the First Result
And Click on LinkText "Edit"
And Update the companyName as TCS
When Submit button is clicked
Then Verify Lead is Edited

@Smoke
Scenario: TC004_Merge Lead

Given Enter username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And click on Login Button
And Homepage should be displayed
And Click on LinkText "CRM/SFA"
And Click on LinkText "Leads"
And Click on LinkText "Merge Leads"
And Click on the first lead
And Click on the second lead
When Click on Merge
Then Verify Lead is merged


@Regression
Scenario: TC005_Delete Lead

Given Enter username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And click on Login Button
And Homepage should be displayed
And Click on LinkText "CRM/SFA"
And Click on LinkText "Leads"
And Click on LinkText "Find Leads"
And Click on the Phone Tabs
And Enter phoneNumber as '9'
And store the firstLead value
And Click on LinkText "Delete"
And Click on LinkText "Find Leads"
And update the lead with the stored value
When click on Delete
Then Verify Lead is Deleted
	
	