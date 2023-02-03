package com.BaseClasses;

import com.Utils.Singleton;
import org.openqa.selenium.By;

class CheckBox extends BaseElement {
    public CheckBox(By locator, String elementName){
        super(locator,elementName);
    }
    public void check(){
        if(!getElement().isSelected()){
            getElement().click();
        }

    }
    public void uncheck(){
        if(getElement().isSelected()){
            getElement().click();
        }

    }
    public boolean isChecked(){
        return getElement().isSelected();
    }
}

