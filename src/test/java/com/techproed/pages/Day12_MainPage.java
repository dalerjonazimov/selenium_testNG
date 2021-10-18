package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day12_MainPage {
    //1. Create constructor
    public Day12_MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //2. Create page objects
    @FindBy(linkText = "Log in")
    public WebElement mainPageLoginButton;

}
