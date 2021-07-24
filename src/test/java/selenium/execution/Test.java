package selenium.execution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import selenium.pages.Login_Page;

public class Test {

    WebDriver driver = null;
    Login_Page loginPage = null;

    @BeforeSuite
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new Login_Page(driver);
        driver.manage().window().maximize();
    }
    @org.testng.annotations.Test
    public void Login_Case() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage.setUsername_Field("Admin");
        loginPage.setPassword_Field("admin123");
        loginPage.clickLogin_Button();
    }

    @AfterSuite
    public void Teardown() {
        driver.quit();
    }

}
