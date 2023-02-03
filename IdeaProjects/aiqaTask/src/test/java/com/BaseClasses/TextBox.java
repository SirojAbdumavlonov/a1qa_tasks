package com.BaseClasses;

import org.openqa.selenium.By;

public class TextBox extends BaseElement{
    public TextBox(By locator, String elementName){
        super(locator, elementName);
    }
    public void typing(String text){
        getElement().sendKeys(text);
    }

    public void clear(){
        getElement().clear();
    }
}