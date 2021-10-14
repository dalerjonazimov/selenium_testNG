package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10_HardAssertion {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void hartAssert(){
        /*
        * When user goes to the application home page
        * and verifies the title equals Caretta Hotel - Home
        * and clicks on login button
        * then verifies the page title equals Caretta Hotel-Login
        * */
        driver.get("http://www.carettahotel.com/");
        //Using hard assertion
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotel"));//FAILED. STOPPED

        //NOTE:Line 38 failed so the rest of the test case will NOT be executed

        //clicking on login button
        driver.findElement(By.linkText("Log in")).getText();
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotel - Log in"));
    }
}
