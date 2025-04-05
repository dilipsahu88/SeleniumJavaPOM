package com.practicetestautomation.tests;

import com.practicetestautomation.tests.exceptions.ExceptionsTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        logger = Logger.getLogger(ExceptionsTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running test in " + browser);
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--headless");
        switch(browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(option);
                break;
            case "firefox":
                driver= new FirefoxDriver(opt);
                break;
            default:
                logger.warning("Configuration for " + browser.toLowerCase() + " is missing, so running test in Chrome browser");
                driver = new ChromeDriver(option);
                break;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Browser is closed");
        driver.quit();
    }
}
