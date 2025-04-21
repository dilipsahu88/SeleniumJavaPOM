package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageobjects.ExceptionPage;
import com.practicetestautomation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionsTests extends BaseTest {


    @Test
    public void noSuchElementExceptionTest() {

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();

        logger.info("Verify if Row2 is displayed");
        Assert.assertTrue(exceptionPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();

        logger.info("Verify if Row2 is displayed");
        Assert.assertTrue(exceptionPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest() {

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();
        exceptionPage.isRowTwoDisplayedAfterWait();

        exceptionPage.enterDetailsInRow2("Sushi");
        exceptionPage.saveRowTwo();

        Assert.assertEquals(exceptionPage.getSuccessMessage(), "Row 2 was saved", "message is not expected");

    }

    @Test
    public void invalidElementStateExceptionTest() {

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushEditButton();
        exceptionPage.enterDetailsInRow1("Sushi");
        exceptionPage.saveRow1();

        Assert.assertEquals(exceptionPage.getSuccessMessage(), "Row 1 was saved", "message is not expected");

    }
    @Test
    public void staleElementReferenceExceptionTest() {

        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();
        Assert.assertTrue(exceptionPage.isInstructionsElementHiddenAfterWait(), "Element is visible");
    }
    @Test
    public void autoBuildCheckOne() {
        System.out.println("CICD Auto Build Kicked");
    }

}
