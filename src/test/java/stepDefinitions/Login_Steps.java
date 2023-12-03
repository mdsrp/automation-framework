package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.io.IOException;

public class Login_Steps extends Base_PO {

    private final WebDriver driver = getDriver();

    public Login_Steps() throws IOException {
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() throws IOException {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter the username {}")
    public void i_enter_the_username(String username) throws IOException {
        sendKeys(By.xpath("//input[@id='text']"), username);
    }
    @When("I enter the password {}")
    public void i_enter_the_password(String password) throws IOException {
        sendKeys(By.xpath("//input[@id='password']"),password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() throws IOException {
//        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        waitWebElementAndClick(By.xpath("//button[@id='login-button']"));
    }

    @Then("I should be presented with the following validation message {}")
    public void iShouldBePresentedWithTheFollowingValidationMessage(String loginValidationMessage) {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,loginValidationMessage);
    }
}