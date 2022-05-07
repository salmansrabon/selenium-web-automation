package Setup;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Setup {
    public WebDriver driver;
    @BeforeTest(groups = {"login","purchase_product"})
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod  //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils(driver);
                util.takeScreenShot();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }

        }

    }

    @AfterTest(groups = "login")
    public void Logout() throws InterruptedException {
        driver.quit();

    }
}

