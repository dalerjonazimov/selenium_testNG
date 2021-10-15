package com.techproed.notes;

public class Day10_Notes {
}
/*

Summary of Day10
TestNG:  Testing Framework, It is advanced version of JUnit
Annotations: Multiple Before and After Annotations
            -@BeforeSuit @AfterSuit
            -@BeforeTest @AfterTest
            -@BeforeGroups @AfterGroups
            -@BeforeClass @AfterClass
            -@BeforeMethod @AfterMethod
@Test : Marks a method as a Test Case. It creates test cases and let us run the test cases.
@Ignore: To skip the test case


***Assertions:
Hard Assertion : It stops execution if the Assertion line fails
Soft Assertion : Continues to the test execution even if the Assertion Line fails. To use soft Assertion we must create softAssert Object:
                    SoftAssert sa = new SoftAssert():
                    sa.assertTrue().... or other assertion you can use
                    sa.assertAll() must be used to mark the assertion as passed or failed.
                    If I do not use this, then the report will always show as PASS

























 */