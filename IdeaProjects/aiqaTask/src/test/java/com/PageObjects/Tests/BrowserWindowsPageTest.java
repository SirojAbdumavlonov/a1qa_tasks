package com.PageObjects.Tests;

import com.BaseClasses.BaseTest;
import com.PageObjects.Pages.BrowserWindowsPage;
import com.PageObjects.Pages.MainPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserWindowsPageTest extends BaseTest {
    MainPage mainPage = new MainPage();
    BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
    @BeforeTest
    public void beforeTestRun(){
        super.beforeTestRun();
    }
    @Test
    public void controllingTabs() {
        mainPage.clickingAlertsFrameWindowsBut();

        mainPage.clickingBrowserWindowsButton();

        browserWindowsPage.clickingNewTabButton();

        browserWindowsPage.closingCurTab();

        mainPage.clickingElementsGroupButton();

        mainPage.clickingLinksButton();

        browserWindowsPage.clickingSimpleLinkButton();

        browserWindowsPage.closingCurTab();
    }



    @AfterTest
    public void afterTestRun(){
        super.afterTestRun();
    }
}
