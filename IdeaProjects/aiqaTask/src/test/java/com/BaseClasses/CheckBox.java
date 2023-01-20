package com.BaseClasses;

import com.Utils.Singleton;
import org.openqa.selenium.By;

class CheckBox extends BaseElement {
    public CheckBox(By locator, String elementName){
        super(locator,elementName);
    }
    public void check(){
        if(!Singleton.driver().findElement(locator).isSelected()){
            Singleton.driver().findElement(locator).click();
        }
        System.out.println("It is already selected!");
    }
    public void uncheck(){
        if(Singleton.driver().findElement(locator).isSelected()){
            Singleton.driver().findElement(locator).click();
        }
        System.out.println("It is not selected yet!");
    }
    public boolean isChecked(){
        return Singleton.driver().findElement(locator).isSelected();
    }
}

