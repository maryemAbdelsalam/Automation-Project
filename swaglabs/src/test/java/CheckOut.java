import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.CartPage;
import org.example.CheckOutPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOut {
    WebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    CartPage cart = new CartPage();
    CheckOutPage checkout = new CheckOutPage();
    @BeforeMethod
    public void OpenCheckOutPage () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        login.usernameElement(driver).sendKeys("standard_user");
        Thread.sleep(500);
        login.passwordElement(driver).sendKeys("secret_sauce");
        Thread.sleep(500);
        login.LoginButtonElement(driver).click();
        Thread.sleep(1000);
        cart.CartElement(driver).click();
        Thread.sleep(500);
        cart.ContShoppingElement(driver).click();
        Thread.sleep(500);
        cart.RandomItem(driver).click();
        Thread.sleep(1000);
        cart.AddRandomItem(driver).click();
        Thread.sleep(500);
        cart.CartElement(driver).click();
        Thread.sleep(3000);
        cart.CheckOutElement(driver).click();
        Thread.sleep(2000);
    }
    @Test
    public void ValidDataFinish() throws InterruptedException {
        checkout.firstnameElement(driver).sendKeys("first name");
        checkout.lastnameElement(driver).sendKeys("last name");
        checkout.PostalCodeElement(driver).sendKeys("123");
        Thread.sleep(3000);
        checkout.ContinueElement(driver).click();
        Thread.sleep(2000);
        checkout.FinsishElement(driver).click();
        String ExpectedMessage = "THANK YOU FOR YOUR ORDER";
        String ActualMessage = checkout.CompleteHeaderElement(driver).getText();
        Assert.assertEquals(ActualMessage.contains(ExpectedMessage),true);
        Thread.sleep(2000);
    }
    @Test
    public void ValidDataCancel() throws InterruptedException {
        checkout.firstnameElement(driver).sendKeys("first name");
        checkout.lastnameElement(driver).sendKeys("last name");
        checkout.PostalCodeElement(driver).sendKeys("123");
        Thread.sleep(3000);
        checkout.ContinueElement(driver).click();
        Thread.sleep(2000);
        checkout.CancelElement(driver).click();
        Thread.sleep(2000);
    }
    @Test
    public void EmptyFirstName() throws InterruptedException {
        checkout.lastnameElement(driver).sendKeys("last name");
        checkout.PostalCodeElement(driver).sendKeys("123");
        Thread.sleep(3000);
        checkout.ContinueElement(driver).click();
        Thread.sleep(2000);
        String ExpectedMessage = "Error: First Name is required";
        String ActualMessage = checkout.ErrorMessage(driver).getText();
        Assert.assertEquals(ActualMessage.contains(ExpectedMessage),true);
    }
    @Test
    public void EmptyLastName() throws InterruptedException {
        checkout.firstnameElement(driver).sendKeys("first name");
        checkout.PostalCodeElement(driver).sendKeys("123");
        Thread.sleep(3000);
        checkout.ContinueElement(driver).click();
        Thread.sleep(2000);
        String ExpectedMessage = "Error: Last Name is required";
        String ActualMessage = checkout.ErrorMessage(driver).getText();
        Assert.assertEquals(ActualMessage.contains(ExpectedMessage),true);
    }
    @Test
    public void EmptyPostalCode() throws InterruptedException {
        checkout.firstnameElement(driver).sendKeys("first name");
        checkout.lastnameElement(driver).sendKeys("last name");
        Thread.sleep(3000);
        checkout.ContinueElement(driver).click();
        Thread.sleep(2000);
        String ExpectedMessage = "Error: Postal Code is required";
        String ActualMessage = checkout.ErrorMessage(driver).getText();
        Assert.assertEquals(ActualMessage.contains(ExpectedMessage),true);
    }
    @AfterMethod
    public void ClosePage (){
        driver.close();
    }
}
