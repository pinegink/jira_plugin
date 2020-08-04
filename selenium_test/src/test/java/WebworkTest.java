import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pure Selenium, not Atlassian-Selenium. Relies on "generated-test-resources.zip" 
 */

public class WebworkTest {
    private static WebDriver driver;
    private static SeleniumRunner runner;
    private final String WEBWORK = "webwork";

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/dev/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        runner = new SeleniumRunner(driver);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void after() {
        driver.quit();
    }

    @Test
    public void emptyKeyPassedShouldReturnTableWithOneProjectAndSixthIssues() throws InterruptedException {
        int proejctsAndIssues[] = runner.getProjectsAndIssuesNumberForProjectKey("", WEBWORK);
        assertEquals(2, proejctsAndIssues[0]);
        assertEquals(7, proejctsAndIssues[1] - 1);
    }

    @Test
    public void rigthtKeyPassedShouldReturnResultingTableWithOneProjectAndSixthIssues() throws InterruptedException {
        int proejctsAndIssues[] = runner.getProjectsAndIssuesNumberForProjectKey("MYP", WEBWORK);
        assertEquals(1, proejctsAndIssues[0]);
        assertEquals(6, proejctsAndIssues[1]);
    }

    @Test
    public void wrongKeyPassedShouldReturnResultingTableWithZeroProjects() throws InterruptedException {
        int proejcts = runner.getProjectsAndIssuesNumberForProjectKey("wrong_key", WEBWORK)[0];
        assertEquals(0, proejcts);
    }
}
