package com.example.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    By searchField = By.xpath("//input[contains(@id,'store_nav_search_term')]");
    By selectSearchField = By.xpath("//*[contains(@id,'search_suggestion_contents')]/a[1]");
    By privacyPolicy = By.xpath("//a[contains(@href,'https://store.steampowered.com/privacy_agreement/?snr=1_44_44_')]");
    By date = By.xpath("//div[contains(@class,'date')]//div[contains(@class,'date')]");
    By reviews = By.xpath("//span[contains(@class,'positive')]");
    By appName = By.xpath("//div[contains(@id,'search_suggestion_contents')]/a[1]/div[1]");
    By appPrice = By.xpath("//div[contains(@class,'match_price')]");
    By appName2 = By.xpath("//div[contains(@id,'search_suggestion_contents')]/a[2]/div[1]");

    public void InputText(String text){
        Singleton.driver().findElement(searchField).sendKeys(text);
    }
    public void SelectFoundData(){
        Singleton.driver().findElement(selectSearchField).click();
    }
    public void selectPrivacyPolicy() throws InterruptedException {
        Singleton.driver().findElement(privacyPolicy).click();
        Thread.sleep(2000);
        Singleton.driver().get("https://store.steampowered.com/");
    }
    public void ScrollingUntilPrivacyPolicy(JavascriptExecutor js){
        WebElement prPo = Singleton.driver().findElement(privacyPolicy);
        js.executeScript("arguments[0].scrollIntoView()",prPo);
    }
    public void Waiting(){
        new WebDriverWait(Singleton.driver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(selectSearchField));
    }
    public String getDate(){
        return Singleton.driver().findElement(date).getText();
    }
    public String getReviews(){
        return Singleton.driver().findElement(reviews).getText();
    }
    public String getNameOfApp(){
        return Singleton.driver().findElement(appName).getText();
    }
    public String getPriceOf1App(){
        return Singleton.driver().findElement(appPrice).getText();
    }
    public String getNameOfSecondResInSearchBox(){
        return Singleton.driver().findElement(appName2).getText();
    }

}
