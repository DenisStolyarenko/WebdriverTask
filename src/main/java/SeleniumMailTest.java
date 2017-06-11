import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SeleniumMailTest {
    private WebDriver driver;
    private String baseUrl;

    @Test(priority = 0)
    public void openSite(){
        driver.get("https://mail.ru");
        driver.findElement(By.id("mailbox"));
    }

    @Test(priority = 1)
    public void loginToMail(){
        WebElement user = driver.findElement(By.id("mailbox__login"));
        user.sendKeys("for.test.95");
        Select changeDomain = new Select(driver.findElement(By.id("mailbox__login__domain")));
        changeDomain.selectByVisibleText("@list.ru");
        WebElement pwd = driver.findElement(By.id("mailbox__password"));
        pwd.sendKeys("QWEasdzxc135");
        WebElement sighin = driver.findElement(By.id("mailbox__auth__button"));
        sighin.click();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //Assert.assertTrue();
    }

    @Test(priority = 2)
    public void logoutToMail(){
        WebElement logoutButton = driver.findElement(By.xpath("//a[@data-title='выход']"));
        logoutButton.click();
    }

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get("https://mail.ru");
    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}
