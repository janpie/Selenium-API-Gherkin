package SeleniumUI.tests.user_registration;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.time.Month;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SeleniumUI.pages.AccountCreationPage;
import SeleniumUI.pages.LandingPage;
import SeleniumUI.pages.enums.AvailableRegistrationCountries;
import SeleniumUI.tests.test_base.TestBase;

public class UnsuccessfulRegistrationTest extends TestBase {

  private LandingPage landingPage;
  private AccountCreationPage accountCreation;

  @BeforeClass
  private void loadObjects() {
    landingPage = new LandingPage(driver, 10);
    accountCreation = new AccountCreationPage(driver, 10);

  }

  @Test
  private void registerUserNoNumber() {
    landingPage.goToSignInPage(10)
        .writeEmailAddressCreateAccount("Mymail1@mail.com")
        .goToCreateAccountPage(10)
        .writeName("Joe")
        .writeSurname("Tester")
        .writeEmail("testmail@mail.com")
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
        .writeMobilePhone("")
        .writeAlias("Alias of dreams")
        .clickOnRegisterButton(10);
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("phone number");
  }

  @Test(dependsOnMethods = "registerUserNoNumber")
  private void registerUserNoName() {
    accountCreation.writeName("")
        .writeSurname("Tester")
        .writeEmail("testmail@mail.com")
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
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("firstname");
  }

  @Test
  private void registerUserNoSurname() {
    accountCreation.writeName("Joe")
        .writeSurname("")
        .writeEmail("testmail@mail.com")
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
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("lastname");
  }

  @Test
  private void registerUserNoPassword() {
    accountCreation.writeName("Joe")
        .writeSurname("Tester")
        .writeEmail("testmail@mail.com")
        .writePassword("")
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
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("passwd");
  }

  @Test
  private void registerUserNoAddress() {
    accountCreation.writeName("Joe")
        .writeSurname("Tester")
        .writeEmail("testmail@mail.com")
        .writePassword("Newuser@123")
        .setDayBirthDropdown(17).setMonthBirthDropdown(Month.DECEMBER).setYearBirthDropdown(1995)
        .optInForNewsletter()
        .writeAddressName("Joe")
        .writeAddressSurname("Tester")
        .writeAddressLine1("")
        .writeCity("Arizona city of dreams")
        .setCountryDropdown(AvailableRegistrationCountries.US)
        .setStateDropdown("Alabama")
        .writeZipCode("00001")
        .writeMobilePhone("500600700")
        .writeAlias("Alias of dreams")
        .clickOnRegisterButton(10);
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("address1");
  }

  @Test
  private void registerUserNoCity() {
    accountCreation.writeName("Joe")
        .writeSurname("Tester")
        .writeEmail("testmail@mail.com")
        .writePassword("Newuser@123")
        .setDayBirthDropdown(17).setMonthBirthDropdown(Month.DECEMBER).setYearBirthDropdown(1995)
        .optInForNewsletter()
        .writeAddressName("Joe")
        .writeAddressSurname("Tester")
        .writeAddressLine1("Hello world")
        .writeCity("")
        .setCountryDropdown(AvailableRegistrationCountries.US)
        .setStateDropdown("Alabama")
        .writeZipCode("00001")
        .writeMobilePhone("500600700")
        .writeAlias("Alias of dreams")
        .clickOnRegisterButton(10);
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("city");
  }

  @Test
  private void registerUserBadZipCode() {
    accountCreation.writeName("Joe")
        .writeSurname("Tester")
        .writeEmail("testmail@mail.com")
        .writePassword("Newuser@123")
        .setDayBirthDropdown(17).setMonthBirthDropdown(Month.DECEMBER).setYearBirthDropdown(1995)
        .optInForNewsletter()
        .writeAddressName("Joe")
        .writeAddressSurname("Tester")
        .writeAddressLine1("Hello world")
        .writeCity("Arizona city of dreams")
        .setCountryDropdown(AvailableRegistrationCountries.US)
        .setStateDropdown("Alabama")
        .writeZipCode("bad zip code")
        .writeMobilePhone("500600700")
        .writeAlias("Alias of dreams")
        .clickOnRegisterButton(10);
    assertThat(accountCreation.getErrorText())
        .contains("1 error")
        .contains("he Zip/Postal code you've entered is invalid.");
  }


}
