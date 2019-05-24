package SeleniumUI.tests.user_registration;

import static org.assertj.core.api.Java6Assertions.assertThat;

import SeleniumUI.Utils.MailGenerator;
import java.time.Month;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SeleniumUI.pages.LandingPage;
import SeleniumUI.pages.MyAccountPage;
import SeleniumUI.pages.enums.AvailableRegistrationCountries;
import SeleniumUI.pages.enums.Gender;
import SeleniumUI.tests.test_base.TestBase;

public class SuccessfulRegistrationTest extends TestBase {

  private LandingPage landingPage;
  private MyAccountPage myAccount;


  @BeforeClass
  private void loadObjects(){
    landingPage = new LandingPage(driver, 10);
    myAccount = new MyAccountPage(driver, 10);
  }


  @Test
  private void registerUser(){

    String mail = MailGenerator.generateRandomEmail();

    landingPage.goToSignInPage(10)
        .writeEmailAddressCreateAccount(mail)
        .goToCreateAccountPage(10)
        .setGender(Gender.MALE)
        .writeName("Joe")
        .writeSurname("Tester")
        .writeEmail(mail)
        .writePassword("Newuser@123")
        .setDayBirthDropdown(17).setMonthBirthDropdown(Month.DECEMBER).setYearBirthDropdown(1995)
        .optInForNewsletter()
        .writeAddressName("Joe")
        .writeAddressSurname("Tester")
        .writeAddressLine1("Hello world")
        .writeCity("Arizona city of dreams")
        .setCountryDropdown(AvailableRegistrationCountries.US)
        .setStateDropdown("Alabama")
        .writeZipCode("00001")
        .writeMobilePhone("500600700")
        .writeAlias("Alias of dreams")
        .clickOnRegisterButton(10);
    assertThat(myAccount.isLoggedIn())
        .isTrue();


  }


}
