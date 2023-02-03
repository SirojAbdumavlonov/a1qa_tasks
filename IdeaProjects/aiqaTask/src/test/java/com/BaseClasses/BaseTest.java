package com.BaseClasses;

import com.Utils.Singleton;
import com.Utils.Drivers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void beforeTestRun(){
        Singleton.setUpDriver(Drivers.CHROME);
        Singleton.driver().manage().window().maximize();
        Singleton.driver().get(BaseForm.mainPage);
    }
    @AfterTest
    public void afterTestRun(){
        Singleton.driver().close();
        Singleton.driver().quit();
        Singleton.driver = null;
    }
}
