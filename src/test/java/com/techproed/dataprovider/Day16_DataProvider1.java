package com.techproed.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day16_DataProvider1 {
    /*
    WORKING WITH DATA PROVIDER
    1. Creating a method that returns 2D object array
    2. Use @DataProvider annotation on the method
    3. Store the test data in this method
    4. We create test method
    5. Use  @Test(dataProvider = "getData") annotation
    --------------------------------------------------
    @DataProvider annotation will pass the data to the test classes
     */

    //Create a method to get data from DataProvider
    //return type of the method is 2D Object Array

    @DataProvider
    public Object[][] getData(){
//  manager   Manager1!
//  manager2  Manager2!
//  manager3  Manager3!
    //We have data above we have to set it. Below we set the data with traditional way:

 /*    Way 1 to add the data

    Object[][] managerProfile = new Object[3][2];  //3 rows(outer) and 2 columns(inner)
//1st row
    managerProfile[0][0] = "manager";
    managerProfile[0][1] = "manager1!";
//2nd row
    managerProfile[1][0] = "manager2";
    managerProfile[1][1] = "manager2!";
//3rd row
    managerProfile[2][0] = "manager3";
    managerProfile[2][1] = "manager3!";


  */
  /*
     Way 2 to add the data   - SHORT WAY- RECOMMENDED WAY
     String [][] managerProfile = {} OR Object [][] managerProfile = {
   */

    Object [][] managerProfile = {
            {"manager", "Manager1!"},
            {"manager2", "Manager2!"},
            {"manager3", "Manager3!"}
    };

    return managerProfile;
    }

    @Test(dataProvider = "getData")
    public void managerInfo(String userName, String password){
        //To get the manager credentials we can use Excel
        //In this class we are going to use DataProvider
        System.out.println("User Name : "+ userName + " \nPassword :" + password);



    }
}
