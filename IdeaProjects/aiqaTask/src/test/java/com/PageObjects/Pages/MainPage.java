package com.PageObjects.Pages;

import com.BaseClasses.BaseForm;
import com.BaseClasses.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final By AlertsFrameWindows = By.xpath("//div[contains(@class,'card mt-4 top-card')][3]");
    private final By Elements = By.xpath("//div[contains(@class,'card mt-4 top-card')][1]");
    private final By Alerts = By.xpath("//div[contains(@class,'element-group')][3]//li[2]");
    private final By nestedFrames = By.xpath("//div[contains(@class,'element-group')][3]//li[4]");
    private final By webTables = By.xpath("//div[contains(@class,'element-group')][1]//li[4]");
    private final By browserWindows = By.xpath("//div[contains(@class,'element-group')][3]//li[1]");
    private final By elementsGroup = By.xpath("//span[contains(@class,'group-header')]");
    private final By links = By.xpath("//div[contains(@class,'element-group')][1]//li[6]");
    //I cannot access to these elements' locators without text() or indexes,
    //I tried a lot of locators, but they were unsuccessful because
    //these elements are the same with similar classes without unique id

    private final Button AlertsButton = new Button(Alerts,"Alerts button");
    private final Button nestedFramesButton = new Button(nestedFrames,"Nested frame button");
    private final Button AlertsFrameWindowsButton = new Button(AlertsFrameWindows,"Alert,Frame&Windows button");
    private final Button ElementsButton = new Button(Elements,"Elements button in main page");
    private final Button webTablesButton = new Button(webTables,"Web Tables button");
    private final Button browserWindowsButton = new Button(browserWindows,"browser windows button");
    private final Button elementsGroupButton = new Button(elementsGroup,"elements button in elements page");
    private final Button linksButton = new Button(links,"Links button");

    public void clickingAlertsFrameWindowsBut(){
        scrollingUntilElement(AlertsFrameWindows);
        AlertsFrameWindowsButton.click();
    }
    public void clickingAlertsButton(){
        scrollingUntilElement(Alerts);
        AlertsButton.click();
    }
    public void clickNestedFramesButton(){
        scrollingUntilElement(nestedFrames);
        nestedFramesButton.click();
    }
    public void clickingElementsButton(){
        scrollingUntilElement(Elements);
        ElementsButton.click();
    }
    public void clickingWebTablesButton(){
        scrollingUntilElement(webTables);
        webTablesButton.click();
    }
    public void clickingBrowserWindowsButton(){
        scrollingUntilElement(browserWindows);
        browserWindowsButton.click();
    }
    public void clickingElementsGroupButton(){
        scrollingUntilElement(elementsGroup);
        elementsGroupButton.click();
    }
    public void clickingLinksButton(){
        scrollingUntilElement(links);
        linksButton.click();
    }

}

