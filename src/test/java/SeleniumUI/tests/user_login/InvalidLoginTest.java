package SeleniumUI.tests.user_login;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SeleniumUI.pages.LandingPage;
import SeleniumUI.pages.SignInPage;
import SeleniumUI.tests.test_base.TestBase;

public class InvalidLoginTest extends TestBase {

  private LandingPage landingPage;
  private SignInPage signIn;

  @BeforeClass
  private void loadObjects() {
    landingPage = new LandingPage(driver, 10);
    signIn = new SignInPage(driver, 10);
  }


  @Test
  private void loginUserNoMail() {
    landingPage.goToSignInPage(10)
        .loginWithCredentials("", "Newuser@123", 10);
    assertThat(signIn.getErrorText())
        .contains("1 error")
        .contains("email");
  }

  @Test(dependsOnMethods = "loginUserNoMail")
  private void loginUserNoPassword() {
    signIn.loginWithCredentials("email@email.com", "", 10);
    assertThat(signIn.getErrorText())
        .contains("1 error")
        .contains("Password");
  }

  @Test
  private void loginInvalidCredentials() {
    landingPage.goToSignInPage(10)
        .loginWithCredentials("invalid@mail.com", "Newuser@123", 10);
    assertThat(signIn.getErrorText())
        .contains("1 error")
        .contains("Authentication failed");
  }


}
