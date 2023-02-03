package com.PageObjects.Pages;

import com.BaseClasses.Button;
import com.BaseClasses.BaseForm;
import com.Utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlertsFrameWindowsPage extends BaseForm {
    private final By seeAlert = By.xpath("//*[contains(@id,'alertButton')]");
    private final By confirmB = By.xpath("//*[contains(@id,'confirmButton')]");
    private final By promptB = By.xpath("//*[contains(@id,'promtButton')]");
    private final Button seeAlertButton = new Button(this.seeAlert,"Seeing alert button");
    private final Button confirmButton = new Button(this.confirmB,"Confirm button");
    private final Button promptBut = new Button(this.promptB,"Prompt button");

    public void clickingSeeingAlertButton(){
        scrollingUntilElement(seeAlert);
        seeAlertButton.click();
    }
    public void acceptingAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    public void selectConfirmButton(){
        scrollingUntilElement(confirmB);
        confirmButton.click();
    }
    public void acceptingConfirmationAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    public void selectPromptButton(){
        scrollingUntilElement(promptB);
        promptBut.click();
    }
    public void acceptPromptBox(){
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(RandomUtils.randomStr());
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
