package SeleniumUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumUI.pages.common.CommonUpperModulePage;

public class SignInPage extends CommonUpperModulePage {

  @FindBy(id = "email_create")
  private WebElement createAccountEmailInput;

  @FindBy(id = "SubmitCreate")
  private WebElement createAccountButton;

  @FindBy(id = "email")
  private WebElement emailLoginInput;

  @FindBy(id = "passwd")
  private WebElement passwordLoginInput;

  @FindBy(id = "SubmitLogin")
  private WebElement loginButton;

  @FindBy(css = "div.alert.alert-danger")
  private WebElement registrationErrorBox;

  public SignInPage(WebDriver driver, int waitTimeout) {
    super(driver, waitTimeout);
    PageFactory.initElements(driver, this);
  }

  public SignInPage writeEmailAddressCreateAccount(String email){
    writeText(email, createAccountEmailInput);
    return this;
  }

  public AccountCreationPage goToCreateAccountPage(int waitTimeout){
    clickOn(createAccountButton);
    return new AccountCreationPage(driver, waitTimeout);
  }

  public MyAccountPage loginWithCredentials(String email, String password, int waitTimeout){
    writeText(email, emailLoginInput);
    writeText(password, passwordLoginInput);
    clickOn(loginButton);
    return new MyAccountPage(driver, waitTimeout);
  }

  public String getErrorText(){
    return getText(registrationErrorBox);
  }





}
