package com.techproed.tests;

import com.techproed.pages.Day12_DefaultPage;
import com.techproed.pages.Day12_HotelRoomsPage;
import com.techproed.pages.Day12_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.nio.channels.WritableByteChannel;
import java.util.List;

public class Day13_WebTables {

    Day12_LoginPage loginPage;
    Day12_DefaultPage defaultPage;
    Day12_HotelRoomsPage hotelRoomsPage;
    @BeforeMethod
    public void setUp(){
//1. go to login page of the application and enter your username, password and click the login button
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage = new Day12_LoginPage(); //we do initialize it because it is different page
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        //asserting login success
        defaultPage = new Day12_DefaultPage(); //we do initialize it because it is different page
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

//2. Click on Hotel Management
        defaultPage.hotelManagementTab.click();
//3. Click on Hotel Rooms
        defaultPage.hotelRoomsTab.click();
//4. Click on Add Hotel Room
        hotelRoomsPage = new Day12_HotelRoomsPage(); //we do initialize it because it is different page

    }
    @Test(groups = "regression-group-1")
    public void entireTable(){

//5.        Create a test method: entireTable() and print all of headers
        System.out.println("*Entire Table*");
        System.out.println("*Table Body*");
        WebElement tableBody = Driver.getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText() );


        List<WebElement> allHeaders = Driver.getDriver().findElements(By.xpath("//th"));
        for(WebElement eachHeader: allHeaders){
            System.out.println(eachHeader.getText());

        }


    }
    @Test(groups = "regression-group-1")
    public void printRows(){
//6.        Create a test method: printRows() and Print all of the rows and print the elements on the 4th row
        System.out.println("*Print Rows*");
        List <WebElement> allRows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        //row numbers
        int rowNum = 1;
        for (WebElement eachRow:allRows){
            System.out.println("Row Number "+ rowNum + "==>" + eachRow.getText());
            rowNum++;
        }

        //Print row4 only
        WebElement row4 = Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("ROW 4 "+ row4.getText());
    }

    @Test
    public void printCells(){
//7.        Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
        System.out.println("*Print Cells*");
        List <WebElement> allCells = Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println("Total Cell Number " + allCells.size());
        int cellNum = 1;
        for (WebElement eachCell: allCells){
            System.out.println(cellNum + ":" + eachCell.getText());
            cellNum+=1;
        }
    }
    @Test
    public void printColumns(){
//8.        Create a test method: printColumns() and print Find the total number of columns and
        List <WebElement>  allHeaders = Driver.getDriver().findElements(By.xpath("//th"));
        int numberOfColumns = allHeaders.size();
        System.out.println("There are " + numberOfColumns + " columns");
    //Print the elements of the 5th column
        int columnNum = 1;
        List<WebElement> column5Data = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//th[5]"));
        for (WebElement eachColumn: column5Data){
            System.out.println("Data " + columnNum +": "+ eachColumn.getText());
            columnNum++;
        }
    }


//        Create a test method: printData(int row, int column); This method should print the given cell. Example:
//        printData(2,3); should print 2nd row,3rd column




    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
