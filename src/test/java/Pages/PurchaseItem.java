package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PurchaseItem {
    WebDriver driver;
    @FindBy(id = "search_query_top")
    WebElement txtSearch;
    @FindBy(name = "submit_search")
    WebElement btnSearch;
    @FindBy(className = "product-container")
    WebElement imgItem;
    @FindBy(name = "Submit")
    WebElement btnSubmit;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement btnSubmit2;
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement btnSubmit3;
    @FindBy(xpath = " //button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement btnSubmit4;
    @FindBy(id = "cgv")
    WebElement chkBox1;
    @FindBy(xpath = " //button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement btnSubmit5;
    @FindBy(className = "bankwire")
    WebElement btnWirecard;
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement btnConfirm;
    @FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
    WebElement lblConfirmation;



    public PurchaseItem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void purchaseItem() throws InterruptedException {
        txtSearch.sendKeys("Dress");
        Thread.sleep(2000);
        btnSearch.click();
        imgItem.click();
        Thread.sleep(1000);
        btnSubmit.click();
        Thread.sleep(3000);
        btnSubmit2.click();
        Thread.sleep(1000);
        btnSubmit3.click();
        Thread.sleep(1000);
        btnSubmit4.click();
        Thread.sleep(1000);
        chkBox1.click();
        btnSubmit5.click();
        Thread.sleep(1000);
        btnWirecard.click();
        Thread.sleep(1000);
        btnConfirm.click();
        Thread.sleep(2000);
        Assert.assertEquals(lblConfirmation.getText(),"Your order on My Store is complete.");

    }
}
