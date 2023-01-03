package com.example.seleniumtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.json.JSONException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    LoginPage loginPage = new LoginPage();
    JavascriptExecutor js = (JavascriptExecutor) Singleton.driver();
    @BeforeTest
    public void launch(){
        WebDriverManager.chromedriver().setup();
        Singleton.driver().manage().window().maximize();
        Singleton.driver().get("https://store.steampowered.com/");
    }
    @Test(priority = 1)
    public void Testing1() throws InterruptedException{
        ArrayList<String> tabs = new ArrayList<String>(Singleton.driver().getWindowHandles());

        loginPage.ScrollingUntilPrivacyPolicy(js);
        Thread.sleep(1000);
        loginPage.selectPrivacyPolicy();
        Singleton.driver().switchTo().window(tabs.get(0));

    }
    @Test(priority = 2)
    public void Testing2() throws JSONException, IOException {
        LoginPage firstSearch = new LoginPage();
        DataOfGames dt = new DataOfGames();
        Singleton.driver().get("https://store.steampowered.com/");
        firstSearch.InputText("Dota 2");
        firstSearch.Waiting();

        String price = firstSearch.getPriceOf1App();//selecting necessary data from website
        String firstname = firstSearch.getNameOfApp();//selecting necessary data from website
        String secondAppName = firstSearch.getNameOfSecondResInSearchBox();//selecting necessary data from website

        firstSearch.SelectFoundData();
        FoundContentPage fb1 = new FoundContentPage();

        String[] firstS = {firstname,price,firstSearch.getReviews(),firstSearch.getDate()};//array of data of first search result
        Singleton.driver().get("https://store.steampowered.com/");

        DataOfGames dt2 = new DataOfGames();
        LoginPage secondSearch = new LoginPage();
        secondSearch.InputText(secondAppName);//searching second found data in search box
        secondSearch.Waiting();

        price = secondSearch.getPriceOf1App();//getting price of app
        secondSearch.SelectFoundData();

        String[] secondS = {secondAppName,price,secondSearch.getReviews(),secondSearch.getDate()};//array of data of second search result
        fb1.writingToFile(dt,firstS,dt2,secondS);//writing data of both searches to json file

        Assert.assertEquals(secondS,fb1.readingFromJson());//assertion to check equality of data and function inside brackets to read stored data
        System.out.println("Tests successfully finished");

    }
    @AfterClass
    public void finish(){
        Singleton.driver().close();
        Singleton.driver().quit();
    }
}


























































//    MainPage mainPage = new MainPage();
//
//    @BeforeClass
//    public static void setUpAll() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        Configuration.browserSize = "1280x800";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        open("https://www.jetbrains.com/");
//    }
//
//    @Test
//    public void search() {
//        mainPage.searchButton.click();
//
//        $("[data-test='search-input']").sendKeys("Selenium");
//        $("button[data-test='full-search-button']").click();
//
//        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
//    }
//
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        $("div[data-test='main-submenu']").shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeAllToolsButton.click();
//
//        $("#products-page").shouldBe(visible);
//
//        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
//    }

