package com.BaseClasses;

import com.Utils.Singleton;
import org.openqa.selenium.By;

class textBox extends BaseElement{
    public textBox(By locator, String elementName){
        super(locator, elementName);
    }
    public void type(String text){
        Singleton.driver().findElement(locator).sendKeys(text);
    }
    public void clear(){
        Singleton.driver().findElement(locator).clear();
    }
}