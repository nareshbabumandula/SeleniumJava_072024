package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.main.Base;

public class ExplicitWaitUtils {

    public WebDriver driver;
    private WebDriverWait wait;

    public ExplicitWaitUtils(WebDriver driver) {
        this.driver = Base.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(60)); // You can adjust the timeout as needed
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeSelected(By locator) {
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void waitForElementTextTobePresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    
    // You can add more custom waiting methods as needed
    public void waitForCustomCondition(ExpectedCondition<Boolean> condition) {
        wait.until(condition);
    }
}
