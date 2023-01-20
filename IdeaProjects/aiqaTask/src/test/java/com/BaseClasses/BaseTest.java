package com.BaseClasses;


import com.Utils.Singleton;
import com.Utils.drivers;

public class BaseTest {
    public void beforeTestRun(){
        Singleton.setUpDriver(drivers.CHROME);
        Singleton.driver().manage().window().maximize();
        Singleton.driver().get(BaseForm.mainPage);
    }
    public void afterTestRun(){
        Singleton.driver().close();
        Singleton.driver().quit();
    }
}
