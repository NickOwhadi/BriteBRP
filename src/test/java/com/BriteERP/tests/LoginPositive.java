package com.BriteERP.tests;

import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPositive extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void loginSalesManager() {
        // give name to the test
        extentLogger = report.createTest("Positive login as Sales manager");
        // prints the passed string to the report, used to capture test steps ...
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Entering username and salesmanager password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        extentLogger.info("Clicking on submit");
        loginPage.submit.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Verifying title contains #Inbox");
        Assert.assertTrue(driver.getTitle().contains("#Inbox"));
        extentLogger.pass("PASSED: Positive login as Sales manager");
    }

    @Test
    public void loginSalesManagerNegative() {
        // give name to the test
        extentLogger = report.createTest("Negative login as Sales manager");
        // prints the passed string to the report, used to capture test steps ...
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_username");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Entering username and wrong salesmanager password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        extentLogger.info("Clicking on submit");
        loginPage.submit.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Verifying title contains Login");
        Assert.assertTrue(driver.getTitle().contains("Login"));
        extentLogger.pass("PASSED: negative login as Sales manager");
    }


}


