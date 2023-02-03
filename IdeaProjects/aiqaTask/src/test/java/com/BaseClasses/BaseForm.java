package com.BaseClasses;

import com.Utils.Singleton;
import com.otherClasses.ConfigurationDataFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseForm {
    private By locator;
    protected WebDriverWait wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(ConfigurationDataFileReader.timeOfWait()));
    static JavascriptExecutor js = (JavascriptExecutor) Singleton.driver();
    public static final String mainPage = ConfigurationDataFileReader.linkToMainPage();

    public static void scrollingUntilElement(By locator){
        js.executeScript("arguments[0].scrollIntoView()",Singleton.driver().findElement(locator));
    }
    public boolean isPageOpened(){
        return Singleton.driver().findElement(locator).isDisplayed();
    }





}

