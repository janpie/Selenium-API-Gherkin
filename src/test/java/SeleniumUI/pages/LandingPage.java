package SeleniumUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import SeleniumUI.pages.common.CommonUpperModulePage;

public class LandingPage extends CommonUpperModulePage {


  public LandingPage(WebDriver driver, int waitTimeout) {
    super(driver, waitTimeout);
    PageFactory.initElements(driver, this);
  }






}
