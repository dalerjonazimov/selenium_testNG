package com.techproed.tests.smoketest;

import com.techproed.pages.Day12_DefaultPage;
import com.techproed.pages.Day12_LoginPage;
import com.techproed.pages.Day12_MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day12_PositiveLoginTest {

    @Test
    public void positiveLoginTest(){
        //1. Go to http://carettahotel.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //2. Crate page object-MainPage, LoginPage   --> DONE
        /*3. Create test class
        -Create Page Objects
            -create MainPage object
            -calling the page elements using that object
         */

        Day12_MainPage mainPage = new Day12_MainPage();
        mainPage.mainPageLoginButton.click();

        //4. At this point we are in the LoginPage
        // Create LoginPage object
        Day12_LoginPage loginPage = new Day12_LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        //loginPage.username.sendKeys("manager"); hardcode
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        //loginPage.password.sendKeys("Manager1!");hardcode
        loginPage.loginButton.click();


        //5.We need to automate the login success
        //We choose a CORE ELEMENT on the page
        //We will use Add User button to verify the login page
        //At this point we are on the Default Page
        Day12_DefaultPage defaultPage = new Day12_DefaultPage();
        boolean isLoggedIn = defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(isLoggedIn);
    }
}
