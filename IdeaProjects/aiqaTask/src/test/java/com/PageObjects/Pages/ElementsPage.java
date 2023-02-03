package com.PageObjects.Pages;

import com.BaseClasses.BaseForm;
import com.BaseClasses.Button;
import com.BaseClasses.TextBox;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    By addNewRecord = By.xpath("//*[contains(@id,'addNewRecordButton')]");
    By firstName = By.xpath("//input[contains(@id,'firstName')]");
    By lastName = By.xpath("//input[contains(@id,'lastName')]");
    By userEmail = By.xpath("//input[contains(@id,'userEmail')]");
    By age = By.xpath("//input[contains(@id,'age')]");
    By salary = By.xpath("//input[contains(@id,'salary')]");
    By department = By.xpath("//input[contains(@id,'department')]");
    By submit = By.xpath("//*[contains(@id,'submit')]");
    By delete = By.xpath("//span[contains(@id,'delete-record-4')]");

    Button addNewRecordButton = new Button(addNewRecord,"Button which adds new records to table");
    TextBox firstNameBox = new TextBox(firstName,"first name textbox");
    TextBox lastNameBox = new TextBox(lastName,"last name textbox");
    TextBox userEmailBox = new TextBox(userEmail,"user email textbox");
    TextBox ageBox = new TextBox(age,"age textbox");
    TextBox salaryBox = new TextBox(salary,"salary textbox");
    TextBox departmentBox = new TextBox(department,"department textbox");
    Button submitButton = new Button(submit,"Submit button to submit data");
    Button deleteButton = new Button(delete,"Delete button to delete record");
    public void clickingAddNewRecordButton(){
        scrollingUntilElement(addNewRecord);
        addNewRecordButton.click();
    }
    public void sendingData(String firstName,String lastName,String email,String age,String salary,String department) throws InterruptedException {

        firstNameBox.typing(firstName);

        lastNameBox.typing(lastName);

        userEmailBox.typing(email);

        ageBox.typing(age);

        salaryBox.typing(salary);

        departmentBox.typing(department);
    }
    public void clickingSubmitButton(){
        submitButton.click();
    }
    public void clickingDeleteButton(){
        deleteButton.click();
    }
}
