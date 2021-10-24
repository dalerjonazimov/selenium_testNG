package com.techproed.excelautomation;

import com.techproed.pages.Day12_DefaultPage;
import com.techproed.pages.Day12_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day15_LoginSmokeTest {

    //creating ExcelUtil object
    ExcelUtil excelUtil;
    //Get the data (username, password) as key-value pairs
    //I will use testData to store username-password values: Use Map<String, String> when there is more than 2 login
    //Map<String, String> :         {manager, manager1!}
    //List<Map<String,String>>:{{manager, Manager1!}, {manager2, Manager2!}, {manager3, Manager3!}}

    List<Map<String,String>> testData;

    //page objects
    Day12_LoginPage loginPage;
    Day12_DefaultPage defaultPage;

    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new Day12_LoginPage();
        Thread.sleep(1000);
  //      if(loginPage.advancedLink.isDisplayed()) {
        try {
            Thread.sleep(1000);
            loginPage.advancedLink.click(); // website is blocking that's why we add steps to handle it. In LoginPage
            Thread.sleep(1000);
            loginPage.proceedLink.click();
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed ");
        }
  //   }
    }

    @Test
    public void adminLoginTest() throws InterruptedException {
        String path = "./src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "admin_login_info";
        excelUtil = new ExcelUtil(path, sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);  //[{password=Techproed123!, username=admin}]

        for(Map<String, String> eachData: testData){ //eachData represent each username-password paris
            setUp(); //login each loop
            //How do we get each data from excel sheet
            loginPage.username.sendKeys(eachData.get("username")); //admin
            loginPage.password.sendKeys(eachData.get("password")); //Techproed123!
            loginPage.loginButton.click();
        }

//        setUp is used to log the application page
//        setUp();
//        loginPage.username.sendKeys("manager");
//        loginPage.password.sendKeys("Manager1!");
//        loginPage.loginButton.click();
    }
    @Test
    public void managerLoginTest() throws InterruptedException {
        String path = "./src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "manager_login_info";
        excelUtil = new ExcelUtil(path, sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);  //[{password=Manager1!, username=manager}, {password=Manager2!, username=manager2}, {password=Manager3!, username=manager3}]

        for(Map<String, String> eachData: testData){ //eachData represent each username-password paris
            setUp(); //login each loop
            //How do we get each data from excel sheet
            loginPage.username.sendKeys(eachData.get("username")); //admin
            loginPage.password.sendKeys(eachData.get("password")); //Techproed123!
            loginPage.loginButton.click();
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}







/*
-TASK:
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
 */
