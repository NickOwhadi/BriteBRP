package com.BriteERP.pages;

import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(css="#top_menu > li:nth-child(10) > a")
//    public WebElement sigin;

    @FindBy(css="input#login")
    public WebElement userNameElement;

    @FindBy(css="input#password")
    public WebElement passwordElement;

    @FindBy (css="button[type='submit']")
    public WebElement loginButtonElement;

    @FindBy(xpath="//p[contains(text(),'Wrong')]")
    public WebElement errorMessageElement;


    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public void login(){
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }
}
