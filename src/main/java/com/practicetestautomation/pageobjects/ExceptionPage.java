package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionPage extends BasePage {

    private By addButton = By.id("add_btn");
    private By row1InputField = By.xpath("//div[@id='row1']/input");
    private By row1SaveButton = By.xpath("//div[@id='row1']/button[@name='Save']");
    private By row2InputField = By.xpath("//div[@id='row2']/input");
    private By row2SaveButton = By.xpath("//div[@id='row2']/button[@name='Save']");
    private By successMessage = By.id("confirmation");
    private By editButton = By.id("edit_btn");
    private By instructionsLocator = By.id("instructions");

    public ExceptionPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void pushAddButton() {
        driver.findElement(addButton).click();
    }
     public boolean isRowTwoDisplayedAfterWait() {
        return waitForIsDisplayed(row2InputField);
     }

    public void enterDetailsInRow1(String name) {
        WebElement row1Input = driver.findElement(row1InputField);
        row1Input.clear();
        row1Input.sendKeys(name);
    }

     public void enterDetailsInRow2(String name) {
        driver.findElement(row2InputField).sendKeys(name);
     }

     public void saveRowTwo() {
        driver.findElement(row2SaveButton).click();
     }

     public String getSuccessMessage() {
        return waitForElement(successMessage).getText();
     }

     public void pushEditButton() {
        driver.findElement(editButton).click();
     }

     public void saveRow1() {
         driver.findElement(row1SaveButton).click();
     }

     public boolean isInstructionsElementHiddenAfterWait() {
         return waitForIsHidden(instructionsLocator);
     }
}
