package TestCase;

import BasePage.BasePage;
import Pages.Login;
import Pages.PurchaseItem;
import Pages.SignUp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestCase extends BasePage {
    SignUp objReg;
    PurchaseItem objPurchase;
    Login objLogin;
    @Test(priority=0,enabled = true, description="User Registration")
    public void doRegistration() throws Exception {
        driver.get("http://automationpractice.com");
        objReg=new SignUp(driver);
        objReg.memberSignUp();
    }
    @Test(priority=1,enabled = true, description="Login")
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin=new Login(driver);
        objLogin.doLogin("testuser9454@test.com","P@ssword123");

    }
    @Test(priority=2,enabled = true, description="Purchase Item")
    public void doPurchage() throws Exception {
        objPurchase=new PurchaseItem(driver);
        objPurchase.purchaseItem();

    }
    @AfterTest
    public void Logout() throws InterruptedException {
        driver.quit();

    }
}
