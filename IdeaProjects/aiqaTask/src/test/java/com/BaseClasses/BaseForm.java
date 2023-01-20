package com.BaseClasses;

import com.Utils.Singleton;
import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseForm {
    private By locator;
    protected WebDriverWait wait = new WebDriverWait(Singleton.driver(), Duration.ofSeconds(2));
    static JavascriptExecutor js = (JavascriptExecutor) Singleton.driver();

    String elementName;


    public static final String mainPage = "https://demoqa.com/";
    public static void scrollingUntilElement(By locator){
        js.executeScript("arguments[0].scrollIntoView()",Singleton.driver().findElement(locator));
    }

    public boolean isPageOpened(){
        return Singleton.driver().findElement(locator).isDisplayed();
    }





}

