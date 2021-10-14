package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day10_TestNGAnnotation {
    /*
    * @Test is used to create Test Cases on TestNG
    * @BeforeMethod is used to run Before each @Test Annotation. Same as @Before us JUnit. Location @BeforeMethod is before Test, console is before Test
    * @AfterMethod is ued to run After @Test annotation. Location @AfterMethod is before @Test but console After the Test
    * @Ignore is used to skip a @Test annotation
    * @Test(enabled = false) also skips the @Test annotation. It is similar to @Ignore
    *
    * Ordering the Test Cases
    * TestNG executes the test cases based on alphabetical order -NOT FROM TO TOP BUTTOM
    * We use priority to run in specific order:
    * @Test(priority = 1)


    * Why would you need @BeforeMethod annotation?
    *   -Pre conditions - Creating driver, maximizing window, time out, to avoid repetition
    *
    * Why would you need @AfterMethod annotation?
    *   -Post conditions - for closing the driver, to avoid repetition, report generation
    *
    * Why would you need @Test annotation?
    *   -To create test case to do assertion
    * */
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
    @Test(priority = 1) //using priority we can put our order by our want
    public void test6(){ //if we type test6. when we run in console first you see test2, test3,..test6.. alphabetical order
        System.out.println("Test 1");
    }
    @Test(enabled = false) //other type of ignoring. when we run test2 do not show result in console
    public void test2(){
        System.out.println("Test 2");
    }
    @Ignore //now it is ignoring the test3. when we run test3 do not show result in console
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("Test 4");
    }
    @Test(priority = 2)
    public void test5(){
        System.out.println("Test 5");
    }
}
