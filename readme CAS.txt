Topic Name: Acronym and Cognizant Stock Price

Problem Statement: Take screenshot of every Acronym and write all that data in excel sheet
                   Compare Cognizant's stock price with google data and retrieve the previous data                     


Detailed Description: 
-Login to be.cognizant.com with a valid registered Email ID 
-Verify if the name and designation of the employee is displayed on the homepage.
-Navigate to be.cognizant-> Company-> Acronyms
-Writting Acronyms in Excel Sheet and take screenshots of every Acronym
-Check Cognizant's stock value matches with Google's Cognizant stock value
-Check current Cognizant's Stock value with previous stock values
-Capture Cognizant Market Cap value


Key Automation Scope:  
-Capturing Screenshots
-Data Driven approach 
-Handling different browsers 
-Handling multiple tabs


About this Project:

src/test/java contains pageObjects,testCases and utilityMethods
-pageObjects package contains page object elements and methods.
-testCases package contains all the test cases.
-utilityMethods package contains extendReport and DateManager.

report folder contains
-automation-report.html is the report generated by using the Extent Reports.

pom.xml contains the dependencies required by the project

testng.xml file is for running the test cases.

test-output folder contains testng report and other files.

Tools and Technologies used:
-Selenium with Java in Eclipse IDE
-TestNG
-Maven
-WebDriverManager
-ExtentReports

