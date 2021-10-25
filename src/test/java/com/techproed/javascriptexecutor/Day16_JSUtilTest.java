package com.techproed.javascriptexecutor;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class Day16_JSUtilTest {

    @Test
    public void scrollIntoView(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement recentBlog = Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        JSUtils.scrollIntoViewJS(recentBlog);
        //What could be the reason waitFor does not work before
        //We need to waitAFTER SCROLLING for the TEXT to display properly
        ReusableMethods.waitFor(2);
        Assert.assertEquals(recentBlog.getText(), "Recent Blog");
    }

    @Test
    public void clickWithJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailabilityButton);
        Driver.closeDriver();
    }
    @Test
    public void flashJS() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement flashBackgroundColor = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flash(flashBackgroundColor);
        Driver.closeDriver();
    }
    @Test
    public void changeColorJS() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement changeColorOfItem = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("red",changeColorOfItem);
        Driver.closeDriver();
    }
}
