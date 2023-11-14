import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.CartPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingCart {
    WebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    CartPage cart = new CartPage();
    @BeforeMethod
    public void OpenCart () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        login.usernameElement(driver).sendKeys("standard_user");
        Thread.sleep(500);
        login.passwordElement(driver).sendKeys("secret_sauce");
        Thread.sleep(500);
        login.LoginButtonElement(driver).click();
        Thread.sleep(500);
        cart.CartElement(driver).click();
        Thread.sleep(1000);
    }
    @Test
    public void ContinueAddDelete () throws InterruptedException {
        cart.ContShoppingElement(driver).click();
        Thread.sleep(1000);
        cart.RandomItem(driver).click();
        Thread.sleep(500);
        cart.AddRandomItem(driver).click();
        Thread.sleep(1000);
        cart.CartElement(driver).click();
        Thread.sleep(3000);
        cart.RemoveRandomItem(driver).click();
        Thread.sleep(2000);
    }
    @Test
    public void ContAddCheckOut () throws InterruptedException {
        cart.ContShoppingElement(driver).click();
        cart.RandomItem(driver).click();
        Thread.sleep(500);
        cart.AddRandomItem(driver).click();
        Thread.sleep(500);
        cart.CartElement(driver).click();
        Thread.sleep(3000);
        cart.CheckOutElement(driver).click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void ClosePage(){
        driver.close();
    }
}
