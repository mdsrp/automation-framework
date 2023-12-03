package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static driver.DriverFactory.getDriver;

public class Login_Steps {

    private final WebDriver driver = getDriver();

    public Login_Steps() throws IOException {
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter the username {}")
    public void i_enter_the_username(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }
    @When("I enter the password {}")
    public void i_enter_the_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"validation succeeded");
    }

    @Then("I should be presented with a unsuccessful login message")
    public void i_should_be_presented_with_a_unsuccessful_login_message() {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"validation failed");
    }

    @Then("I should be presented with the following validation message {}")
    public void iShouldBePresentedWithTheFollowingValidationMessage(String loginValidationMessage) {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,loginValidationMessage);
    }
}