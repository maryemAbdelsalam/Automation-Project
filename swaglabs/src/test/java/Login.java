import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login {
    WebDriver driver ;
    LoginPage login = new LoginPage();

    @BeforeMethod
    public void OpenBrowser () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
    }
    @Test
    public void ValidLogin () throws InterruptedException {
        login.usernameElement(driver).sendKeys("standard_user");
        Thread.sleep(1000);
        login.passwordElement(driver).sendKeys("secret_sauce");
        Thread.sleep(1000);
        login.LoginButtonElement(driver).click();
    } // login with valid username and password

    @Test
    public void invalidLogin1 (){
        login.usernameElement(driver).sendKeys("username");
        login.passwordElement(driver).sendKeys("password");
        login.LoginButtonElement(driver).click();
        String errormessage = login.ErrorMessage(driver).getText();
        String actualmessange = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualmessange.contains(errormessage),true);
    } // login with invalid username and invalid password
    @Test
    public void invalidLogin2 (){
        login.usernameElement(driver).sendKeys("standard_user");
        login.LoginButtonElement(driver).click();
        String errormessage = login.ErrorMessage(driver).getText();
        String actualmessange = "Epic sadface: Password is required";
        Assert.assertEquals(actualmessange.contains(errormessage),true);
    } // login with valid username and empty password
    @Test
    public void invalidLogin3 () {
        login.passwordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
        String errormessage = login.ErrorMessage(driver).getText();
        String actualmessange = "Epic sadface: Username is required";
        Assert.assertEquals(actualmessange.contains(errormessage), true);
    } // login with valid password and empty username
    @Test
    public void invalidLogin4 (){
        login.usernameElement(driver).sendKeys("username");
        login.passwordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
        String errormessage = login.ErrorMessage(driver).getText();
        String actualmessange = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualmessange.contains(errormessage),true);
    } // login with valid password and invalid username
    @Test
    public void invalidLogin5 (){
        login.usernameElement(driver).sendKeys("standard_user");
        login.passwordElement(driver).sendKeys("password");
        login.LoginButtonElement(driver).click();
        String errormessage = login.ErrorMessage(driver).getText();
        String actualmessange = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualmessange.contains(errormessage),true);
    } // login with valid username and invalid password
    @Test
    public void invalidLogin6 (){
        login.LoginButtonElement(driver).click();
        String errormessage = login.ErrorMessage(driver).getText();
        String actualmessange = "Epic sadface: Username is required";
        Assert.assertEquals(actualmessange.contains(errormessage),true);
    } // login leaving both username and password empty

    @AfterMethod
    public void CloseBrowser () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
