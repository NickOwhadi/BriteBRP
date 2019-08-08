package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNavPage {
    public MainNavPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void NavPage(String linkTxt){
            Driver.getDriver().findElement(By.linkText(linkTxt)).click();
    }
}
