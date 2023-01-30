package com.PageObjects.Tests;

import com.BaseClasses.BaseTest;
import com.PageObjects.Pages.MainPage;
import com.PageObjects.Pages.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NestedFramesPageTests extends BaseTest {
    MainPage mainPage = new MainPage();
    NestedFramesPage nestedPage = new NestedFramesPage();
    @BeforeTest
    public void beforeTestRun(){
        super.beforeTestRun();
    }

    @Test
    public void nestedFrames(){
        mainPage.clickingAlertsFrameWindowsButton();
        mainPage.clickNestedFramesButton();

        nestedPage.usingOuterFrame();
        Assert.assertEquals(nestedPage.gettingTextOfOuterFrame(),"Parent Frame");

        nestedPage.usingInnerFrame();
        Assert.assertEquals(nestedPage.gettingTextOfInnerFrame(),"Child Iframe");

    }

    @AfterTest
    public void afterTestRun(){
        super.afterTestRun();
    }
}
