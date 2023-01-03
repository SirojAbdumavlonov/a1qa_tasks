package com.example.seleniumtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
    private static WebDriver driver;
    private Singleton(){

    }
    public static WebDriver driver(){
        WebDriverManager.chromedriver().setup();
        if(driver == null)
            driver = new ChromeDriver();

        return driver;
    }
}
