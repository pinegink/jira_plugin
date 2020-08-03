package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final String URL = "http://localhost:2990/jira/secure/Dashboard.jspa";
    private WebDriver driver;
    @FindBy(id = "login-form-username")
    private WebElement username;
    @FindBy(id = "login-form-password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void inputUsername(String username) {
        this.username.sendKeys(username);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void loginCLick() {
        loginButton.click();

    }
}
