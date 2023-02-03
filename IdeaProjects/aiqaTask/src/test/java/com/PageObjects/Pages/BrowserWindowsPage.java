package com.PageObjects.Pages;

import com.BaseClasses.BaseForm;
import com.BaseClasses.Button;
import com.Utils.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class BrowserWindowsPage extends BaseForm {
    private ArrayList<String> tabs;
    private String mainPage;
    private static  final By newTab = By.xpath("//button[contains(@id,'tabButton')]");
    private final By simpleLink = By.xpath("//*[contains(@id,'simpleLink')]");
    private final Button simpleLinkButton = new Button(simpleLink,"Home button with address to another website");
    private static final Button newTabButton = new Button(newTab,"New tab Button");
    public void clickingNewTabButton(){
        mainPage = Singleton.driver().getWindowHandle();
        scrollingUntilElement(newTab);
        newTabButton.click();
    }
    public void closingCurTab() {
        tabs = new ArrayList<String>(Singleton.driver().getWindowHandles());
        Iterator<String> iterator = tabs.iterator();
        while(iterator.hasNext()){
            String newTab = iterator.next();
            if(!Objects.equals(mainPage, newTab)){
                Singleton.driver().switchTo().window(newTab);
                Singleton.driver().close();
                Singleton.driver().switchTo().window(mainPage);
            }
        }
    }
    public void clickingSimpleLinkButton(){
        scrollingUntilElement(simpleLink);
        simpleLinkButton.click();
    }
}
