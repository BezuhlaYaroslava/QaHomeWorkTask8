package Task8Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.DressesPage;
import page.HomePage;

public class Task8Test {

    private DressesPage dressesPage;
    private WebDriver driver;
    private HomePage homePage;
    private String actualResult;
    private String expectedResult;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
    }

    @Test
    public void canMakePurchase() {
        homePage = new HomePage(driver);
        dressesPage = homePage.openWomen();
        dressesPage.endOrder();

        actualResult = dressesPage.getPrise();
        expectedResult = dressesPage.getTotalProducts();

        Assert.assertEquals(expectedResult, actualResult);

    }

}
