import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.CartPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home {
    WebDriver driver;
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    CartPage cart = new CartPage();

    @BeforeTest
    public void OpenHomePage () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        login.usernameElement(driver).sendKeys("standard_user");
        login.passwordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
    }
    @Test
    public void AddHighest () throws InterruptedException {
        Select DropDown = new Select(home.DropDownElement(driver));
        DropDown.selectByVisibleText("Price (high to low)");
        Thread.sleep(7000);
        home.HighestElement(driver).click();
        String Expectedprice = "49.99";
        String Actualprice = home.Highestprice(driver).getText();
        Assert.assertEquals(Actualprice.contains(Expectedprice), true);
        Thread.sleep(2000);
        home.AddToCart(driver).click();
        Thread.sleep(3000);
    }
    @Test
    public void AddLowest () throws InterruptedException {
        Select DropDown = new Select(home.DropDownElement(driver));
        DropDown.selectByVisibleText("Price (low to high)");
        Thread.sleep(7000);
        home.LowestElement(driver).click();
        String Expectedprice = "7.99";
        String Actualprice = home.Lowestprice(driver).getText();
        Assert.assertEquals(Actualprice.contains(Expectedprice), true);
        Thread.sleep(2000);
        home.AddToCart(driver).click();
        Thread.sleep(3000);
    }
    @Test
    public void AssertItems () throws InterruptedException {
        cart.CartElement(driver).click();
        Thread.sleep(3000);
        String Expectedprice = "49.99";
        String Actualprice = cart.Highestprice(driver).getText();
        Assert.assertEquals(Actualprice.contains(Expectedprice), true);
        String Expectedprice2 = "7.99";
        String Actualprice2 = cart.Lowestprice(driver).getText();
        Assert.assertEquals(Actualprice2.contains(Expectedprice2), true);
    }
    @AfterMethod
    public void BackToHome () {
        driver.navigate().back();

    }
}
