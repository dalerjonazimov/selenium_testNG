package com.techproed.tests;

import com.techproed.pages.Day12_TestAddressLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day12_TestAddressLoginTest {

    @Test
    public void testAddressLogin(){

        //Going to the application page
        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));
        //Creating page object
        Day12_TestAddressLoginPage testAddressLoginPage = new Day12_TestAddressLoginPage();
        //Sing in application
        testAddressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAddressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAddressLoginPage.signInButton.click();
        //closing the driver
        Driver.closeDriver();
    }


    //There are 100 test cases and you used password in all 100 tests
    //and password changes
    //What do you do to fix your automation code?
    //Without configuration.properties:   go to 100 tests and change the passwords 100 times
    //With configuration.properties file: go to configuration.properties file and change the value of password


    /*
    ABOVE and BELOW are same. ABOVE is using configuration.properties file and ConfigReader class; and BELOW traditional way
      //Going to the application page
        Driver.getDriver().get("http://a.testaddressbook.com/sign_in");
        //Creating page object
        Day12_TestAddressLoginPage testAddressLoginPage = new Day12_TestAddressLoginPage();
        //Sing in application
        testAddressLoginPage.email.sendKeys("testtechproed@gmail.com");
        testAddressLoginPage.password.sendKeys("Test1234!");
        testAddressLoginPage.signInButton.click();
        //closing the driver
        Driver.closeDriver();
     */
}
