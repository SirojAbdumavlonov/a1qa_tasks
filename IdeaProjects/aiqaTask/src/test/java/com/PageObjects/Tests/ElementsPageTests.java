package com.PageObjects.Tests;

import com.BaseClasses.BaseTest;
import com.PageObjects.Pages.ElementsPage;
import com.PageObjects.Pages.MainPage;
import com.otherClasses.TestDataFileReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    ElementsPage elementsPage = new ElementsPage();
    @BeforeTest
    public void beforeTestRun(){
        super.beforeTestRun();
    }
    @DataProvider
        public Object[][] textBoxes(){
        return new Object[][]{
                TestDataFileReader.readingDataOfUser1().toArray(new String[0]),//executed
                TestDataFileReader.readingDataOfUser2().toArray(new String[0])//not executed, problem occured
        };
    }
    @Test
    public void elementsPageFunctions(){

        mainPage.clickingElementsButton();

        mainPage.clickingWebTablesButton();

    }
    @Test(dataProvider = "textBoxes")
    public void sendingData(String firstName,String lastName,String email,String age,String salary,String department) throws InterruptedException {
        // First time test is implemented while second one does not
        // I have an error while sending data second time 'org.testng.internal.reflect.MethodMatcherException'
        //which I cannot fix

        elementsPage.clickingAddNewRecordButton();

        elementsPage.sendingData(firstName, lastName, email, age, salary, department);

        elementsPage.clickingSubmitButton();

        elementsPage.clickingDeleteButton();

    }

    @AfterTest
    public void afterTestRun(){
        super.afterTestRun();
    }
}
