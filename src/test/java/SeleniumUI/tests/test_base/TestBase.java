package SeleniumUI.tests.test_base;

import SeleniumUI.config.DriverFactory;
import SeleniumUI.config.browser.enums.Browser;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

  protected WebDriver driver;

  @BeforeTest
  public void initiateDriver(){
    driver = new DriverFactory().createDriver(Browser.CHROME);
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().window();
    driver.get("http://automationpractice.com/index.php");

  }

  @AfterTest
  public void quitDriver(){
    driver.quit();
  }

}
