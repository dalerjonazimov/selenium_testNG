package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Similar to TestBase, Thi is a utilities class
    private static WebDriver driver; //Driver instance
 /*getDriver() method is used:
 * 1.SetUp driver
 * 2.create driver
 * 3.return driver
 * driver---->>>>>> Driver.getDriver()
 * */
    //==@Before==//
    public static WebDriver getDriver(){

        if(driver==null){  //if driver is not pointing anywhere, then instantiate the driver

            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                    //headless browser runs in the background without actual browser on the screen
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
    //==@After==//
    public static void closeDriver(){
        if (driver!=null){ //if driver is pointing somewhere at if driver is being used
            driver.quit(); //close the driver
            driver=null;   //then make driver null so that we can instantiate driver again
        }
    }

}
