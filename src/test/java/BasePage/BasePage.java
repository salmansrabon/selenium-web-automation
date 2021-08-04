package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;
    @BeforeTest(groups = "Purchase_Product")
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,5);
    }
}

