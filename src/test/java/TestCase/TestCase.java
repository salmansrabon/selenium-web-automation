package TestCase;

import BasePage.BasePage;
import Pages.Login;
import Pages.PurchaseItem;
import Pages.SignUp;
import Utility.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestCase extends BasePage{
    SignUp objReg;
    PurchaseItem objPurchase;
    Login objLogin;

    @Test(priority = 1, enabled = false, description = "User Registration", groups = "Registration")
    public void doRegistration() throws Exception {
        driver.get("http://automationpractice.com");
        objReg = new SignUp(driver);
        objReg.memberSignUp();
    }

    @Test(priority = 2, enabled = true, description = "Login", groups = "Purchase_Product")
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject = (JSONObject) obj;

        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        objLogin.doLogin(email, password);

    }

    @Test(priority = 3, enabled = true, description = "Purchase Item", groups = "Purchase_Product")
    public void doPurchage() throws Exception {
        objPurchase = new PurchaseItem(driver);
        objPurchase.purchaseItem();


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

    @AfterTest
    public void Logout() throws InterruptedException {
        driver.quit();

    }
}
