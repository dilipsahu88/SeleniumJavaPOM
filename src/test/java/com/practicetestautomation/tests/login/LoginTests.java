package com.practicetestautomation.tests.login;

import com.practicetestautomation.pageobjects.LoginPage;
import com.practicetestautomation.pageobjects.SuccessfulLoginPage;
import com.practicetestautomation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(groups = {"positive", "regression", "smoke"})
    public void testLoginFunctionality() {

        logger.info("Starting testLoginFunctionality Test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        SuccessfulLoginPage successfulLoginPage = loginPage.executeLogin("student", "Password123");
        successfulLoginPage.load();
        Assert.assertEquals(successfulLoginPage.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        logger.info("Verify the login Success Message on Screen");
        Assert.assertTrue(successfulLoginPage.getPageSource().contains("Congratulations student. You successfully logged in!"));
        Assert.assertTrue(successfulLoginPage.isLogoutButtonDisplayed());

    }
    @Parameters({"username", "password", "expectedErrorMessage"})
    @Test(groups = {"negative", "regression"})
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) throws InterruptedException{

        logger.info("Starting negative LoginTest");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.executeLogin(username, password);

        logger.info("Verify Error Message On Screen");
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);

    }
}
