import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import pageObject.ResultPage;
import pageObject.SelectPage;
import pageObject.TopBar;

import java.util.concurrent.TimeUnit;

public class SeleniumRunner {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static SelectPage selectPage;
    private static TopBar topBar;
    private static ResultPage resultPage;
    private final String SERVLET = "servlet";
    private final String WEBWORK = "webwork";

    public SeleniumRunner(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        selectPage = new SelectPage(driver);
        topBar = new TopBar(driver);
        resultPage = new ResultPage(driver);
    }

    public int[] getProjectsAndIssuesNumberForProjectKey(String key, String type) throws InterruptedException {
        int result[] = new int[2];
        int projects;
        int issues;
        loginPage.open();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        loginPage.inputUsername("admin");
        loginPage.inputPassword("admin");
        loginPage.loginCLick();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        topBar.adminMenuClick();
        if (type.equals(SERVLET)) {
            topBar.serverButtonClick();
        } else if (type.equals(WEBWORK)) {
            topBar.webworkButtonClick();
        } else {
            throw new InvalidArgumentException("invalid type. Only servlet and webwork can be tested");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectPage.setProjectKey(key);
        selectPage.clickSubmit();
        Thread.sleep(5000); // there should be a Selenium method
        projects = resultPage.projectsTableSize() - 1;
        issues = resultPage.issuesTableSize() - 1;
        topBar.userOptionsClick();
        topBar.logOutClick();
        result[0] = projects;
        result[1] = issues;
        return result;
    }
}
