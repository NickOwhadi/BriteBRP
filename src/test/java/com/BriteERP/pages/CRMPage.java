package com.BriteERP.pages;

public class CRMPage {
    String url = "http://54.148.96.210/";
    String singIn = "#top_menu > li:nth-child(10) > a";
    String email = "input[name='login']";
    String password = "input[name='password']";
    String loginButton = "button[type='submit']";
    String CRM_Moduel = "//nav/div/ul/li/a/span[@class='oe_menu_text' and contains(text(), 'CRM')]";
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

}
