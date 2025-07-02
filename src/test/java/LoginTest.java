
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void successfulLoginAndListItems() {
        loginPage.goTo();
        loginPage.login("standard_user", "secret_sauce");

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL is incorrect!", "https://www.saucedemo.com/inventory.html", actualUrl);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
