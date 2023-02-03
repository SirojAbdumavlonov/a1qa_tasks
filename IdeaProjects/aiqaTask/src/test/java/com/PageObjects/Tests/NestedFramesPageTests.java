package com.PageObjects.Tests;

import com.BaseClasses.BaseTest;
import com.PageObjects.Pages.MainPage;
import com.PageObjects.Pages.NestedFramesPage;
import com.otherClasses.TestDataFileReader;
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
        mainPage.clickingAlertsFrameWindowsBut();

        mainPage.clickNestedFramesButton();

        nestedPage.usingOuterFrame();

        Assert.assertEquals(nestedPage.gettingTextOfOuterFrame(),TestDataFileReader.outerFramesOutput());

        nestedPage.usingInnerFrame();

        Assert.assertEquals(nestedPage.gettingTextOfInnerFrame(), TestDataFileReader.innerFrameOutput());

        nestedPage.returningToMainFrame();
    }

    @AfterTest
    public void afterTestRun(){
        super.afterTestRun();
    }
}
