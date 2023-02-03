package com.BaseClasses;

import com.Utils.Drivers;
import com.Utils.Singleton;
import com.otherClasses.ConfigurationDataFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BaseElement {
    protected By locator;
    protected String elementName;
    protected WebDriverWait wait;

    public BaseElement(By locator, String elementName){
        Singleton.setUpDriver(Drivers.CHROME);
        this.locator = locator;
        this.elementName = elementName;
        wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(ConfigurationDataFileReader.timeOfWait()));

    }

    public String getText(){
        return getElement().getText();
    }
    public WebElement getElement(){
        return Singleton.driver().findElement(locator);
    }
    public void click(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        getElement().click();
    }
//    public Boolean isDisplayed(){
//        return wait.until(ExpectedConditions.(locator));
//    }
    //I cannot find an appropriate boolean method for this function

}



