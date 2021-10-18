package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.channels.WritableByteChannel;

public class Day12_TestAddressLoginPage {
    //This is the page class
    //This will have only page objects and main important methods

    //1. Create constructor -obj creator to initialize Driver, 'this' refer to do this page object
    //PageFactory.initElements initialize this page object
    public Day12_TestAddressLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //2. Create page objects
    //Note: we can locate using all 8 locators
    @FindBy(id="session_email") //its similar FindByElement in JUnit
    public WebElement email;

    @FindBy(xpath="//input[@id='session_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='commit']")
    public WebElement signInButton;
}
