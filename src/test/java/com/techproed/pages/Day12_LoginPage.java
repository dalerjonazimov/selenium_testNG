package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day12_LoginPage {
    public Day12_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="UserName")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement errorIdMessage;

    @FindBy(xpath ="//div[@id='divMessageResult']")
    public WebElement errorIdAndPasswordMessage;


}
