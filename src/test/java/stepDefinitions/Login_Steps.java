package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Workspace/automation-framework/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter the username {word}")
    public void i_enter_the_username(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }
    @And("I enter the password {word}")
    public void i_enter_the_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
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

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }
}