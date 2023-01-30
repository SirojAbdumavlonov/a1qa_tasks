package com.PageObjects.Tests;

import com.BaseClasses.BaseTest;
import com.PageObjects.Pages.AlertsFrameWindowsPage;
import com.PageObjects.Pages.MainPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class AlertsFrameWindowsPagesTests extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(AlertsFrameWindowsPagesTests.class);
    Throwable exception;

    MainPage mainPage = new MainPage();
    AlertsFrameWindowsPage AlertsPage = new AlertsFrameWindowsPage();
    @BeforeTest
    public void beforeTestRun(){
        super.beforeTestRun();
    }

    @Test(priority = 1)
    public void firstAlert(){
        mainPage.clickingAlertsFrameWindowsButton();
        mainPage.clickingAlertsButton();
        LOGGER.error("Unexpected error",exception);
        AlertsPage.clickingSeeingAlertButton();
        AlertsPage.acceptingAlert();
        LOGGER.error("error in opening alert",exception);

    }
    @Test(priority = 2)
    public void secondConfirmAlert(){
        AlertsPage.selectConfirmButton();
        AlertsPage.acceptingConfirmationAlert();
        LOGGER.error("error in opening alert",exception);

    }
    @Test(priority = 3)
    public void thirdromptAlert(){
        AlertsPage.selectPromptButton();
        AlertsPage.acceptPromptBox();
        LOGGER.error("error in opening alert",exception);

    }


    @AfterTest
    public void afterTestRun(){
        super.afterTestRun();
    }
}
