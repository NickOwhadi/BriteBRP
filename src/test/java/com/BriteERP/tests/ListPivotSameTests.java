package com.BriteERP.tests;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.pages.MainNavPage;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ListPivotSameTests extends TestBase {


    @Test
    public void preCond3OppsBRP() {
        extentLogger = report.createTest("Pre-condition: each CRM manager " +
                "user should create at least 3 opportunities on the CRM module. ");
        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");
        pages.loginPage().login(username, password);
        extentLogger.info("Going to CRM page");
        pages.crmPage().NavPage("CRM");
        BrowserUtils.waitFor(2);
        extentLogger.info("Clicking Create button");
        pages.crmPage().createButtton.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Naming Opportunity as Book Brand New");
        pages.crmPage().oppsTitle.sendKeys("Book Brand New");
        extentLogger.info("Clearing defualt amount");
        pages.crmPage().expectRevenue.clear();
        extentLogger.info("Entering 300 amount");
        pages.crmPage().expectRevenue.sendKeys("300");
        extentLogger.info("Finalizing creation of opportunity");
        pages.crmPage().saveOppBtn.click();
        BrowserUtils.waitFor(2);


        extentLogger.info("Clicking Create button");
        pages.crmPage().createButtton.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Naming Opportunity as Book Sale");
        pages.crmPage().oppsTitle.sendKeys("Book Sale");
        extentLogger.info("Clearing defualt amount");
        pages.crmPage().expectRevenue.clear();
        extentLogger.info("Entering 500 amount");
        pages.crmPage().expectRevenue.sendKeys("500");
        extentLogger.info("Finalizing creation of opportunity");
        pages.crmPage().saveOppBtn.click();
        BrowserUtils.waitFor(2);


        extentLogger.info("Clicking Create button");
        pages.crmPage().createButtton.click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Naming Opportunity as Mac Book Pro 15");
        pages.crmPage().oppsTitle.sendKeys("Mac Book Pro 15");
        extentLogger.info("Clearing defualt amount");
        pages.crmPage().expectRevenue.clear();
        extentLogger.info("Entering 3500 amount");
        pages.crmPage().expectRevenue.sendKeys("3500");
        extentLogger.info("Finalizing creation of opportunity");
        pages.crmPage().saveOppBtn.click();
        BrowserUtils.waitFor(2);
        extentLogger.pass("Verified 3 opprtunities created");

    }


    @Test
    public void valueCheckOppsBRP() {
        extentLogger = report.createTest("Second opportunity’ Expected Revenue value " +
                "on the Pivot board should be the sameas the Expected revenue column value on the list board");
        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");
        pages.loginPage().login(username, password);
        extentLogger.info("Going to CRM page");
        new MainNavPage().NavPage("CRM");
        BrowserUtils.waitFor(5);
        extentLogger.info("Going to List view by clicking the List Button");
        pages.crmPage().btnList.click();
        List<String> cellsListTxt = new ArrayList<>();
        extentLogger.info("Extraxting texts of related List");
        for (WebElement cellText : pages.crmPage().allCellList
        ) {
            cellsListTxt.add(cellText.getText());
        }
        extentLogger.info("Going to Pivot view by clicking the Pivot Button");
        pages.crmPage().btnPivot.click();
        BrowserUtils.waitFor(5);
        extentLogger.info("Achieving expansion of numbers, as part of pre-condition");
        pages.crmPage().expandTotal.click();
        pages.crmPage().expandTotal.click();
        pages.crmPage().opplink.click();
        extentLogger.info("Extraxting texts of related pivot");
        List<String> cellsPivotTxt = new ArrayList<>();
        for (WebElement cellText1 : pages.crmPage().allCellPivot
        ) {
            cellsPivotTxt.add(cellText1.getText());
        }
        cellsPivotTxt.remove(2);
        extentLogger.info("Verifying that the name and the amount from pivot" +
                " is present in the table list in List view");
        Assert.assertTrue(cellsListTxt.contains(cellsPivotTxt.get(0)));
        Assert.assertTrue(cellsListTxt.contains(cellsPivotTxt.get(1)));
        extentLogger.info("Verifying even the table row in List View" +
                "contains the whole table's row in pivot view");
        Assert.assertTrue(cellsListTxt.containsAll(cellsPivotTxt));
        extentLogger.pass("Verified name and amount are in same row" +
                "and are the same");

    }

    @Test
    public void sumCheckOppsBRP() throws InterruptedException {
        extentLogger = report.createTest("On the pivot table, the total expected " +
                "revenue should be the sum of all opportunities’ expected revenue.");
        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");
        pages.loginPage().login(username, password);
        extentLogger.info("Going to CRM page");
        new MainNavPage().NavPage("CRM");
        extentLogger.info("Going to pivot view");
        pages.crmPage().btnPivot.click();
        BrowserUtils.waitFor(5);
        extentLogger.info("Achieving expansion of numbers, as part of pre-condition");
        pages.crmPage().expandTotal.click();
        pages.crmPage().expandTotal.click();
        pages.crmPage().opplink.click();
        BrowserUtils.waitFor(5);
        extentLogger.info("Extracting amount's text");
        List<String> amountListTxt = new ArrayList<>();
        for (WebElement nums : pages.crmPage().amountList) {
            amountListTxt.add(nums.getText());
        }
        extentLogger.info("Extracting amount with one decimal from text");
        amountListTxt.replaceAll(n->n.replaceAll(",",""));
        List<Double> amountListNum=new ArrayList<>();
        for(int i=0; i<amountListTxt.size(); i++){
            amountListNum.add(Double.parseDouble(amountListTxt.get(i)));
        }
        double total=amountListNum.get(0);
        double calculatedSum=0.00;
        System.out.println(amountListNum);
        for(int i=1; i<amountListNum.size(); i++){
            calculatedSum+=amountListNum.get(i);
        }
        extentLogger.info("Printing the toyal");
        System.out.println(total);
        extentLogger.info("Printing the sum of the list");
        System.out.println(calculatedSum);
        extentLogger.info("Verifying the 2 amounts are equal");
        Assert.assertEquals(total,calculatedSum);
        extentLogger.pass("PASSED:the TOTAL amount is equal to sum of the amount");
    }
}



