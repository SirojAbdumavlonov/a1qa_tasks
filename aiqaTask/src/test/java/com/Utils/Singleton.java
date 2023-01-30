package com.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Singleton {
    public static WebDriver driver;
    public static String driverName;

    private Singleton(){

    }
    public static String setUpDriver(String driverName){
        return driverName;
    }
    public static WebDriver driver(){
        ChromeOptions opt = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        if(driver == null){
            if(setUpDriver(driverName) == null || setUpDriver(driverName).equals("chrome")){
                driver = new ChromeDriver(opt);
            }
            else if(setUpDriver(driverName).equals("firefox")){
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
