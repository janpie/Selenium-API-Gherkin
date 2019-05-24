package SeleniumUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumUI.pages.common.CommonUpperModulePage;

public class MyAccountPage extends CommonUpperModulePage {

  @FindBy(css = "p.info-account")
  private WebElement createAccountEmailInput;


  public MyAccountPage(WebDriver driver, int waitTimeout) {
    super(driver, waitTimeout);
    PageFactory.initElements(driver, this);
  }

  public boolean isLoggedIn(){
    return getText(createAccountEmailInput).contains("Welcome to your account");
  }




}
