package com.PageObjects.Pages;

import com.BaseClasses.BaseElement;
import com.BaseClasses.Button;
import com.Utils.Singleton;
import org.openqa.selenium.By;

import static com.BaseClasses.BaseForm.scrollingUntilElement;

public class MainPage {
    private final By AlertsFrameWindows = By.xpath("//div[contains(@class,card-up)]//div[3]");

    private final By Alerts = By.xpath("//div[contains(text(),Alerts)]");
    private final By nestedFrames = By.xpath("//div[contains(text(),Nested Frames)]");
    private final BaseElement AlertsButton = new Button(this.Alerts,"Alerts button");
    private final BaseElement nestedFramesButton = new Button(nestedFrames,"Nested frame button");
    private final BaseElement AlertsFrameWindowsButton = new Button(this.AlertsFrameWindows,"Alert,Frame&Windows button");

    public void clickingAlertsFrameWindowsButton(){
        scrollingUntilElement(this.AlertsFrameWindows);
        Singleton.driver().findElement(this.AlertsFrameWindows).click();
    }
    public void clickingAlertsButton(){
        scrollingUntilElement(this.Alerts);
        this.AlertsButton.click();
    }


    public void clickNestedFramesButton(){
        scrollingUntilElement(nestedFrames);
        this.nestedFramesButton.click();
    }

}
