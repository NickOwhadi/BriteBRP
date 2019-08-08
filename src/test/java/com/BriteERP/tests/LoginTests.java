package com.BriteERP.tests;

import com.BriteERP.pages.LoginPage;
import com.BriteERP.pages.MainNavPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTest1() {
        extentLogger = report.createTest("Login as salesmanager");

        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");

        pages.loginPage().login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("web"));
        extentLogger.pass("PASSED: login succesful, #Inbox ispageTitle");
    }

    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest1() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        pages.loginPage().login("wrongusername", "wrongpassword");
        Assert.assertEquals(pages.loginPage().getErrorMessage(), "Wrong login/password");
        extentLogger.pass("Verified that Message present: " + pages.loginPage().getErrorMessage());
    }


    @Test(dataProvider = "credentials_info") // get data from data provider
    public void loginWithDataProvider(String username, String password) {
        extentLogger = report.createTest("Login as salesmanager");
        System.out.println(username+"  ::  "+password);
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session

        pages.loginPage().login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully

    }

    @DataProvider(name = "credentials_info")
    public static Object[][] credentials() {
        return new Object[][] { { "storemanager85", "UserUser123" },
                { "salesmanager110", "UserUser123" }};

    }


    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest2() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        pages.loginPage().login("wrongusername", "wrongpassword");
        softAssert.assertEquals(pages.loginPage().getErrorMessage(), "Wrong login/password");
        extentLogger.pass("Verified that Message present: " + pages.loginPage().getErrorMessage());
    }


}
