package com.BriteERP.utilities;


import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.pages.MainNavPage;

public class Pages {
    private LoginPage loginPage;
    private CRMPage crmPage;
    private MainNavPage mainNavPage;



    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CRMPage crmPage() {
        if (crmPage == null) {
            crmPage = new CRMPage();
        }
        return crmPage;
    }



    public MainNavPage mainNavPage() {
        if (mainNavPage == null) {
            mainNavPage = new MainNavPage();
        }
        return mainNavPage;
    }
}
