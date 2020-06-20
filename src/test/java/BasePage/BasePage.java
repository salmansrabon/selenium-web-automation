package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        //InputHandler.ReadConfigFile();
        //ops.addArguments("--disable-notifications");
        ops.addArguments("disable-infobars");
//        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
//        driver = new ChromeDriver(ops);

        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver(ops);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,5);
    }
}

