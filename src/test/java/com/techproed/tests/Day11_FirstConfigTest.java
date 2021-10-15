package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_FirstConfigTest {

    @Test
    public void firstConfigTest(){
 //     go to app_url

//      Driver.getDriver().get("http://carettahotel.com/"); //Hard Coding
//      Instead we can use ConfigReader.getProperty("app_url")
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

 //Assert the title equals Caretta Hotel -Home
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle= ConfigReader.getProperty("app_title");
        Assert.assertEquals(actualTitle, expectedTitle);


    }
}
