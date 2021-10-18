package com.techproed.tests.smoketest;

import com.techproed.pages.Day12_DefaultPage;
import com.techproed.pages.Day12_HotelRoomsPage;
import com.techproed.pages.Day12_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

//1. Class: HotelRoomCreating
public class Day12_HotelRoomCreation {

    Day12_LoginPage loginPage;
    Day12_DefaultPage defaultPage;
    Day12_HotelRoomsPage hotelRoomsPage;
    @BeforeMethod
    public void setUp(){
        //go to login page of the application and enter your username, password and click the login button
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage = new Day12_LoginPage(); //we do initialize it because it is different page
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        //asserting login success
        defaultPage = new Day12_DefaultPage(); //we do initialize it because it is different page
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

    }
    @Test
    public void hotelRoomCreate() throws InterruptedException {
//2. Click on Hotel Management
        defaultPage.hotelManagementTab.click();
//3. Click on Hotel Rooms
        defaultPage.hotelRoomsTab.click();
//4. Click on Add Hotel Room
        hotelRoomsPage = new Day12_HotelRoomsPage(); //we do initialize it because it is different page
        hotelRoomsPage.addHotelRoomLink.click();
//5. Enter All required fields
        //ID IS DROPDOWN
        Select select = new Select(hotelRoomsPage.idDropdown);
        select.selectByIndex(2);

        //Code
        hotelRoomsPage.code.sendKeys("discount code");
//6. To enter a price, we can send keys, OR we can use actions class to drag and drop
        //Name
        hotelRoomsPage.name.sendKeys("Royal Kind Room");
        //Location
        hotelRoomsPage.location.sendKeys("Royal King Palace Hotel in Downtown New York");
        //Description
        hotelRoomsPage.description.sendKeys("This is the best room in the hotel");
        //Price (you can type or drag drop)
    //    hotelRoomsPage.price.sendKeys("700"); //1. way: typing way
        Actions actions = new Actions(Driver.getDriver()); //2. way using Action object,  able to use dragdrop
        Thread.sleep(1000);
        actions.dragAndDrop(hotelRoomsPage.price700,hotelRoomsPage.price).perform();//(source, target)

        //Room Type
        Select roomTypeDropdown = new Select(hotelRoomsPage.roomTypeDropdown);
        roomTypeDropdown.selectByVisibleText("Studio");

        //Adult
        hotelRoomsPage.maxAdultCount.sendKeys("2");

        //Child
        hotelRoomsPage.maxChildrenCount.sendKeys("3");

        //Approved Check Box
        hotelRoomsPage.isApprovedCheckbox.click();

//7. Click Save
        hotelRoomsPage.saveButton.click();


        //ASSERTION FAILS CAUSE WINDOW POP UP TAKES SOME TIME TO OPEN- less than a sec
        //synchronization  ISSUE, we can handle it with Explicit Wait. Sometimes Implicit Wait does not help

        //1.WAY - Thread.sleep(1000) - not recommended
        //2.WAY - Explicit Wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement popUpMessage = wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.popupMessage));

//8. Verify the message: "HotelRoom was inserted successfully"
        //Assert message
        Assert.assertEquals(hotelRoomsPage.popupMessage.getText(), "HotelRoom was inserted successfully");

//9. Click OK
        hotelRoomsPage.okButton.click();

    }
}