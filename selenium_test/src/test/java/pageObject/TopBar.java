package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBar {
    private WebDriver driver;
    @FindBy(id = "log_out")
    private WebElement logOut;
    @FindBy(id = "admin_menu")
    private WebElement adminMenu;
    @FindBy(id = "user-options")
    private WebElement userOptions;
    @FindBy(id = "section1_key")
    private WebElement serverButton;
    @FindBy(id = "section2_key")
    private WebElement webworkButton;

    public TopBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void adminMenuClick() {
        adminMenu.click();
    }

    public void userOptionsClick() {
        userOptions.click();
    }

    public void serverButtonClick() {
        serverButton.click();
    }

    public void webworkButtonClick() {
        webworkButton.click();
    }

    public void logOutClick() {
        logOut.click();
    }
}
