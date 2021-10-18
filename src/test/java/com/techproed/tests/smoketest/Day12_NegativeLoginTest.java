package com.techproed.tests.smoketest;

import com.techproed.pages.Day12_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_NegativeLoginTest {
    //SMOKE TEST- WRONG PASSWORD
    @Test
    public void invalidPassword(){
//1. Go to app_url_login = http://www.carettahotel.com/Account/Login
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        Day12_LoginPage loginPage = new Day12_LoginPage();
//When user enters wrong password only
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));//right id
        loginPage.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));//wrong pass
        loginPage.loginButton.click();
//Then verify the error message includes "Wrong password"
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Wrong password"));

        Driver.closeDriver();
        //Done
    }
    //SMOKE TEST - WRONG ID
    @Test
    public void invalidId(){
//1. Go to app_url_login = http://www.carettahotel.com/Account/Login
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        Day12_LoginPage loginPage2 = new Day12_LoginPage();
//2. When user enters wrong id only
        loginPage2.username.sendKeys(ConfigReader.getProperty("wrong_manager_username"));//wrong id
        loginPage2.password.sendKeys(ConfigReader.getProperty("manager_password"));//right pass
        loginPage2.loginButton.click();
//3.Then verify the error message includes "Try again please"
        String actualIdErrorMessage = loginPage2.errorIdMessage.getText();
        Assert.assertTrue(actualIdErrorMessage.contains("Try again please"));

        Driver.closeDriver();
        //Done
    }
    //SMOKE TEST - WRONG ID AND PASSWORD
    @Test
    public void invalidIdAndPassword(){
//1. Go to app_url_login = http://www.carettahotel.com/Account/Login
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        Day12_LoginPage loginPage3 = new Day12_LoginPage();
//2. When user enters wrong id and password
        loginPage3.username.sendKeys(ConfigReader.getProperty("wrong_manager_username"));//wrong id
        loginPage3.password.sendKeys(ConfigReader.getProperty("wrong_manager_password"));//wrong password
        loginPage3.loginButton.click();
//3.Then verify the error message includes "Username and password is incorrect, please correct then and try again"
        String actualIdAndPassword = loginPage3.errorIdAndPasswordMessage.getText();
        Assert.assertTrue(actualIdAndPassword.contains("Username and password is incorrect, please correct then and try again"));

        Driver.closeDriver();
        //Done
    }
}
