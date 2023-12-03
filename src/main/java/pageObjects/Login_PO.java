package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Login_PO extends Base_PO{

    private @FindBy (id = "text")
    WebElement username_Textfield;

    private @FindBy (id = "password")
    WebElement password_Textfield;

    private @FindBy (id = "login-button")
    WebElement login_Button;


    public Login_PO() throws IOException {
        super();
    }

    public void navigateTo_WebDriverUniversity_Login_Page() throws IOException {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    public void setUsername(String username) throws IOException {
        sendKeys(username_Textfield, username);
    }

    public void setPassword(String password) throws IOException {
        sendKeys(password_Textfield, password);
    }

    public void clickOn_LoginButton() throws IOException {
        waitWebElementAndClick(login_Button);
    }
}