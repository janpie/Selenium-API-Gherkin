package SeleniumUI.config;

import SeleniumUI.config.browser.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

  private WebDriver driver;

  public WebDriver createDriver(Browser browser) {
    switch (browser) {
      case FIREFOX:
        WebDriverManager.firefoxdriver().arch64().setup();
        driver = new FirefoxDriver(CapabilitiesProvider.getFirefoxOptions());
        break;
      case CHROME:
        WebDriverManager.chromedriver().arch32().setup();
        driver = new ChromeDriver(CapabilitiesProvider.getChromeOptions());
        break;
      case INTERNET_EXPLORER:
        WebDriverManager.iedriver().arch64().setup();
        driver = new InternetExplorerDriver();
        break;
      case OPERA:
        WebDriverManager.operadriver().arch64().setup();
        break;
    }
    return driver;
  }
}
