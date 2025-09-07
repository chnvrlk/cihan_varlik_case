package org.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void enterText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    protected boolean isElementPresent(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected void hoverAndClickElement(By hoverLocator, By clickLocator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(hoverLocator)).perform();
        clickElement(clickLocator);
    }

    protected void hoverElement(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).perform();
    }

    protected void scrollWithPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ");");
    }

    protected void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }


    protected void clickWithJs(By locator) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        js.executeScript("arguments[0].click();", element);
    }

    public List<String> getAllElementsText(By locator) {
        List<String> elementsTextList = new ArrayList<>();
        List<WebElement> elements = findElements(locator);

        for (WebElement element : elements) {
            elementsTextList.add(element.getText());
        }
        return elementsTextList;
    }

    protected boolean checkAllElementsTextByText(By locator, String expectedText) {
        List<String> elementsTextList = getAllElementsText(locator);

        for (String elementText : elementsTextList) {
            if (!elementText.equals(expectedText)) {
                return false;
            }
        }
        return true;
    }

    protected void switchToWindow() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public boolean waitForElementText(By locator, String expectedText) {
        return wait.until(ExpectedConditions.textToBe(locator, expectedText));
    }

}