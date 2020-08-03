package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPage {
    private final String URL = "http://localhost:2990/jira/plugins/servlet/servlet";
    private WebDriver driver;
    @FindBy(id = "form-submit")
    private WebElement submit;
    @FindBy(id = "form-input")
    private WebElement projectKey;

    public SelectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void setProjectKey(String projectKey) {
        this.projectKey.sendKeys(projectKey);
    }

    public void clickSubmit() {
        submit.click();
    }
}
