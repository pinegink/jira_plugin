package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int issuesTableSize() {
        List<WebElement> rows = driver.findElements(By.xpath("//*[contains(@id, 'issues-table')]/tbody/tr"));
        return rows.size();
    }

    public int projectsTableSize() {
        List<WebElement> rows = driver.findElements(By.xpath("//*[contains(@id, 'main-table')]/tbody/tr"));
        return rows.size();
    }

}
