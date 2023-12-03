package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static driver.DriverFactory.getDriver;

public class Contact_Us_Steps {

    private final WebDriver driver = getDriver();

    public Contact_Us_Steps() throws IOException {
    }

    @Given("I access the webdriver university contact us page")
        public void i_access_the_webdriver_university_contact_us_page () {
            driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        }

        @When("I enter a unique first name")
        public void i_enter_a_unique_first_name () {
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        }

        @And("I enter a unique last name")
        public void i_enter_a_unique_last_name () {
            Faker faker = new Faker();
            String lastName = faker.name().lastName();
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        }

        @And("I enter a unique email address")
        public void i_enter_a_unique_email_address () {
            Faker faker = new Faker();
            String emailAddress = faker.internet().safeEmailAddress();
            driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(emailAddress);
        }

        @And("I enter a unique comment")
        public void i_enter_a_unique_comment () {
            Faker faker = new Faker();
            String comment = String.valueOf(faker.lordOfTheRings());
            driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(comment);
        }

        @And("I click on the submit button")
        public void i_click_on_the_submit_button () {
            driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        }

        @Then("I should be presented with a successful contact us submission message")
        public void i_should_be_presented_with_a_successful_contact_us_submission_message () {
            WebElement ContactUs_Submission_Message = driver.findElement(By.xpath("//h1[normalize-space()='Thank You for your Message!']"));
            Assert.assertEquals(ContactUs_Submission_Message.getText(),"Thank You for your Message!");
        }

        @When("I enter a specific first name {word}")
        public void i_enter_a_specific_first_name(String firstName) {
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        }

        @When("I enter a specific last name {word}")
        public void i_enter_a_specific_last_name(String lastName) {
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        }

        @When("I enter a specific email address {word}")
        public void i_enter_a_specific_email_address(String emailAddress) {
            driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(emailAddress);
        }

        @When("I enter a specific comment {string}")
        public void i_enter_a_specific_comment(String comment) {
            driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(comment);
    }
}