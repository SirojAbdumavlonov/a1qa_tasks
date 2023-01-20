package com.PageObjects.Pages;

import com.BaseClasses.BaseElement;
import com.BaseClasses.Button;
import com.BaseClasses.BaseForm;
import com.Utils.Singleton;
import com.Utils.randomUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlertsFrameWindowsPage extends BaseForm {
    private final Alert accept = Singleton.driver().switchTo().alert();
    private final  Alert confirm = Singleton.driver().switchTo().alert();
    private final  Alert prompt = Singleton.driver().switchTo().alert();

    private final By seeAlert = By.xpath("//div[contains(@id,alertButton)]");
    private final By confirmB = By.xpath("//div[contains(@id,confirmButton)]");
    private final By prmptB = By.xpath("//div[contains(@id,promtButton)]");
    private final BaseElement seeAlertButton = new Button(this.seeAlert,"Seeing alert button");
    private final BaseElement confirmButton = new Button(this.confirmB,"Confirm button");
    private final BaseElement promptBut = new Button(this.prmptB,"Prompt button");



    public void clickingSeeingAlertButton(){
        scrollingUntilElement(this.seeAlert);
        this.seeAlertButton.click();
    }
    public void acceptingAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        accept.accept();
    }
    public void selectConfirmButton(){
        scrollingUntilElement(this.confirmB);
        this.confirmButton.click();
    }
    public void acceptingConfirmationAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        confirm.accept();
    }
    public void selectPromptButton(){
        scrollingUntilElement(this.prmptB);
        this.promptBut.click();
    }
    public void acceptPromptBox(){
        wait.until(ExpectedConditions.alertIsPresent());
        prompt.sendKeys(randomUtils.randomStr());
        prompt.accept();
    }

}
