package com.PageObjects.Pages;

import com.BaseClasses.BaseElement;
import com.BaseClasses.BaseForm;
import com.BaseClasses.Button;
import com.Utils.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NestedFramesPage extends BaseForm {
    private final String idOfOuterFrame = "frame1";

    private final String bodyOfFrame = "body";
    By outerFrame = By.id("frame1");

    By innerFrame = By.xpath("//iframe[contains(body,'Child Iframe')]");

    private void waitingOfFramesVisibilaty(By locator){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public void usingOuterFrame(){
        waitingOfFramesVisibilaty(outerFrame);
        Singleton.driver().switchTo().frame(idOfOuterFrame);
    }
    public String gettingTextOfOuterFrame(){
        return Singleton.driver().findElement(By.id(bodyOfFrame)).getText();
    }
    public void usingInnerFrame(){
        waitingOfFramesVisibilaty(innerFrame);
        Singleton.driver().switchTo().frame(Singleton.driver().findElement(innerFrame));
    }
    public String gettingTextOfInnerFrame(){
        return Singleton.driver().findElement(innerFrame).getText();
    }




}
