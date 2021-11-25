package com.techproed.dataprovider;

import com.techproed.pages.Day12_DefaultPage;
import com.techproed.pages.Day12_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day16_DataProvider2 {
    /*
    Test the login functionality with manager credentials
    Create a data as 2S object array in getData method
     */
    @DataProvider(name = "manager-profiles", parallel = true)
    public Object[][] getData(){
        Object [][] managerProfile = {
                {"manager", "Manager1!"},
                {"manager2", "Manager2!"},
                {"manager3", "Manager3!"}
        };

        return managerProfile;
    }

    Day12_LoginPage loginPage;
    Day12_DefaultPage defaultPage;
    //Create setUp method for prerequisite
    public void setUp(){
        loginPage = new Day12_LoginPage();
        defaultPage = new Day12_DefaultPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        try {
            ReusableMethods.waitFor(1);
            loginPage.advancedLink.click();
            ReusableMethods.waitFor(1);
            loginPage.proceedLink.click();
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed ");
        }


    }

    @Test(dataProvider = "getData") // the functionality the (dataProvider="getData") is Test can see @DataProvider
    public void managerLoginTest(String managerID, String managerPass){
        setUp();
        loginPage.username.sendKeys(managerID);
        loginPage.password.sendKeys(managerPass);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(defaultPage.userID.getText(), managerID); //manager   manager1    manager2
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
