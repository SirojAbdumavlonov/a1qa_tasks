package com.BaseClasses;

import com.Utils.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

public class BaseElement {
    By locator;
    String elementName;
    WebDriverWait wait;
    WebDriver driver;

    Logger logger;
    public BaseElement(By locator, String elementName){
        this.locator = locator;
        this.elementName = elementName;
        wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(2));
        driver = Singleton.driver();
    }

    public String getText(){
        return Singleton.driver().findElement(locator).getText();
    }
    public WebElement getElement(){
        return Singleton.driver().findElement(locator);
    }
    public void click(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        getElement().click();
    }
    public Boolean isDisplayed(){
        return !wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}



