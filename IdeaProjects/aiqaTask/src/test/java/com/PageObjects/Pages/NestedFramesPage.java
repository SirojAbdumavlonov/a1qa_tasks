package com.PageObjects.Pages;

import com.BaseClasses.BaseForm;
import com.Utils.Singleton;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {
    By outerFrame = By.id("frame1");
    public void usingOuterFrame(){
        Singleton.driver().switchTo().frame(Singleton.driver().findElement(outerFrame));
    }
    public String gettingTextOfOuterFrame(){
        return Singleton.driver().findElement(By.tagName("body")).getText();
    }
    //I used here finding by tagName because there wasn't any other locators(classes or ids)
    //there is only body with text and #document
    //this approach was used below too
    public void usingInnerFrame(){
        Singleton.driver().switchTo().frame(0);
    }
    public String gettingTextOfInnerFrame(){
        return Singleton.driver().findElement(By.tagName("body")).getText();
    }
    public void returningToMainFrame(){
        Singleton.driver().switchTo().defaultContent();
    }
}
