package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Base_PO {

    public Base_PO() throws IOException {
        PageFactory.initElements(getDriver(),this);

    }

    public WebDriver getDriver() throws IOException {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) throws IOException {
        getDriver().get(url);
    }

    public void sendKeys(By by, String textToType) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);

    }

    public void sendKeys(WebElement element, String textToType) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);

    }

    public void waitWebElementAndClick (By by) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitWebElementAndClick (WebElement element) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
