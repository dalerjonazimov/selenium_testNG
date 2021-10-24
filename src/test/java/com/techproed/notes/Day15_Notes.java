package com.techproed.notes;

public class Day15_Notes {
}
/*
HOW DO YOU USE EXCEL IN YOUR FRAMEWORK
-We use EXCEL for data drive testing
-We get multiple data and use in our test case
-For example, I have the application credentials in the excel sheet
    -I use that excel to get the credentials from the excel sheet
    -I store the admin credentials, manager credentials, customer service credentials,


-TASK: day15_LoginSmokeTest-Answer in Day15_LoginSmokeTest
    - Test the log in functionality of the application with different user profile(admin, manager, customer service, end user)
    - Test Data URL https://qa-environment.resortsline.com/Account/Logon
    - User Credentials : Excel Sheet

    STEPS:
        1. Prepare the data:
            a) add url in config properties
            b) add smoke test excel sheet in the resources
            c) create your automation scripts
                   -Java Class: LoginSmokeTest
                   -Methods   : adminLoginTest
                   -Methods   : managerLoginTest

===SUMMARY OF DAY 15==== EXCEL AUTOMATION

-Excel Automation
    -Apache Poi library is used for working with Microsoft Files
    -WorkBook>WorkSheet>Row>Cell
-ExcelUtils
    -We have reusable methods
    -Getting the list of data as List or Map or Array
    -Getting the number of rows, or columns  or using excel file


-How do you use an EXCEL currently in your framework?
 I have  ExcelUtil class in my project. I have reusable methods, I use it to automate, some of the functionalities
    such as login functionality, creating reservation functionality, check out functionality

 I basically use an EXCEL automation WHEN I NEED ESPECIALLY MULTIPLE DATA IN MY AUTOMATION SCRIPT
    for example: When I test login functionality with different user profiles, then I get data from excel

 We can do Data Driver Testing with Excel. Data Driven Testing is when we get multiple data tp test the functionality
    We sent multiple data and check if all test cases passed with the different data. We can basically control
    the test scenarios by just changing the test data. Ex: in login functionality, we have different type of data(admin, manager, customer)
    When I get the different profiles, the test outcome will change. This is an example of DDT.

 We use EXCEL to protect the test data as well. When I have the data in an EXCEL file ,  then the data is not get lost.
    as long as I have the EXCEL file, then I can access the data.


 */
