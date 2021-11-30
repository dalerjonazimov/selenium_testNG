package com.techproed.extentreports;

import com.techproed.pages.Day12_DefaultPage;
import com.techproed.pages.Day12_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReports1 extends TestBase {

    Day12_LoginPage loginPage = new Day12_LoginPage();
    Day12_DefaultPage defaultPage = new Day12_DefaultPage();
    @Test
    public void extentReports1(){
        logger.pass("Entering the username");
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        logger.pass("Entering the password");
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        logger.pass("Clicking the login button");
        loginPage.loginButton.click();
        logger.pass("Assert if login is successful");
        Assert.assertEquals(defaultPage.userID.getText(), ConfigReader.getProperty("manager_username"));
        logger.pass("Test is successful");
    }
}
