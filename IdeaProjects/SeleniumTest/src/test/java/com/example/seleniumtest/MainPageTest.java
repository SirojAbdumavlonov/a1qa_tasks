package com.example.seleniumtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

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
    public void Testing2(){
        Singleton.driver().get("https://store.steampowered.com/");
        loginPage.InputText("Dota 2");
        loginPage.Waiting();
        System.out.println(loginPage.getPriceOfApp());
        loginPage.SelectFoundData();
        System.out.println(loginPage.getReviews());
        System.out.println(loginPage.getNameOfApp());
        System.out.println(loginPage.getDate());

        Singleton.driver().get("https://store.steampowered.com/");

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

