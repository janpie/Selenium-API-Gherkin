package SeleniumUI.tests.user_login;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SeleniumUI.pages.AccountCreationPage;
import SeleniumUI.pages.LandingPage;
import SeleniumUI.pages.MyAccountPage;
import SeleniumUI.tests.test_base.TestBase;

public class LoginTest extends TestBase {

  private LandingPage landingPage;
  private MyAccountPage myAccount;


  @BeforeClass
  private void loadObjects(){
    landingPage = new LandingPage(driver, 10);
    myAccount = new MyAccountPage(driver, 10);
  }


  @Test
  private void loginUser(){
    landingPage.goToSignInPage(10)
        .loginWithCredentials("Mymail@mail.com", "Newuser@123", 10);
    assertThat(myAccount.isLoggedIn())
        .isTrue();
  }


}
