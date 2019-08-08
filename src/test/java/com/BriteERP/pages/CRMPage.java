package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.BriteERP.utilities.Driver.getDriver;

public class CRMPage extends MainNavPage{
//    String url = "http://54.148.96.210/";
//    String singIn = "#top_menu > li:nth-child(10) > a";
//    String email = "input[name='login']";
//    String password = "input[name='password']";
//    String loginButton = "button[type='submit']";
//    String CRM_Moduel = "//nav/div/ul/li/a/span[@class='oe_menu_text' and contains(text(), 'CRM')]";
    String createButton1 = "button[accesskey=c]";
    String opporunityTitle = "input.o_field_char.o_field_widget.o_input.o_required_modifier";
    String customerInputCSS = "div[name='partner_id'] input[id^='o_field_input_']";
    String createOppoButton = "button[name=close_dialog]";
    String createContactButtonXpath = "(//div[@class='modal-content']//button[.='Create'])[2]";
    String listBtn = "button[data-view-type='list']";
    String deleteBtn = "a[data-index='3']";
    String oprtCheckBox = "(//input[1])[7]";
    String action = "//button[contains(text(), 'Action')]";
    String confirmOKbutton = "//span[contains(text(), 'Ok')]";

    public CRMPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(css="button[accesskey=c]")
    public WebElement createButtton;

    @FindBy(css="input[name=name]")
    public WebElement oppsTitle;

    @FindBy(css="input[name=planned_revenue]")
    public WebElement expectRevenue;

    @FindBy(css="button[name=close_dialog]")
    public WebElement saveOppBtn;

    @FindBy(css="button[accesskey=l]")
    public WebElement btnList;

    @FindBy(css="button[aria-label=pivot]")
    public WebElement btnPivot;

    @FindBy(css="//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']//tr")
    public List<WebElement> listsRows;

    @FindBy(css="td[style='padding-left: 5px;']")
    public WebElement expandTotal;

    @FindBy(linkText = "Opportunity")
    public WebElement opplink;

    @FindBy(xpath = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[3]/td")
    public List<WebElement> allCellPivot;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr[2]/td")
    public List<WebElement> allCellList;

    @FindBy(css = "table[class='table-hover table-condensed table-bordered'] td:nth-child(2)")
    public List<WebElement> amountList;
}
