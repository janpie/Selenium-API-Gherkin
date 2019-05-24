package SeleniumUI.pages;

import java.time.Month;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumUI.pages.common.CommonUpperModulePage;
import SeleniumUI.pages.enums.AvailableRegistrationCountries;
import SeleniumUI.pages.enums.Gender;

public class AccountCreationPage extends CommonUpperModulePage {

  @FindBy(id = "id_gender1")
  private WebElement maleButton;

  @FindBy(id = "id_gender2")
  private WebElement femaleButton;

  @FindBy(id = "customer_firstname")
  private WebElement personalNameInput;

  @FindBy(id = "customer_lastname")
  private WebElement personalSurnameInput;

  @FindBy(id = "email")
  private WebElement emailInput;

  @FindBy(id = "passwd")
  private WebElement passwordInput;

  @FindBy(id = "days")
  private WebElement dayBirthDropdown;

  @FindBy(id = "months")
  private WebElement monthBirthDropdown;

  @FindBy(id = "years")
  private WebElement yearBirthDropdown;

  @FindBy(id = "uniform-newsletter")
  private WebElement newsletterCheckbox;

  @FindBy(id = "uniform-optin")
  private WebElement optInCheckbox;

  @FindBy(id = "firstname")
  private WebElement addressNameInput;

  @FindBy(id = "lastname")
  private WebElement addressSurnameInput;

  @FindBy(id = "company")
  private WebElement companyInput;

  @FindBy(id = "address1")
  private WebElement addressline1Input;

  @FindBy(id = "address2")
  private WebElement addressline2Input;

  @FindBy(id = "city")
  private WebElement city;

  @FindBy(id = "id_state")
  private WebElement stateDropdown;

  @FindBy(id = "postcode")
  private WebElement zipCodeInput;

  @FindBy(id = "id_country")
  private WebElement countryDropdown;

  @FindBy(id = "other")
  private WebElement otherInfoInput;

  @FindBy(id = "phone")
  private WebElement homePhoneInput;

  @FindBy(id = "phone_mobile")
  private WebElement mobilePhoneInput;

  @FindBy(id = "alias")
  private WebElement aliasInput;

  @FindBy(id = "submitAccount")
  private WebElement registerButton;

  @FindBy(css = "div.alert.alert-danger")
  private WebElement registrationErrorBox;


  public AccountCreationPage(WebDriver driver, int waitTimeout) {
    super(driver, waitTimeout);
    PageFactory.initElements(driver, this);
  }


  public AccountCreationPage setGender(Gender gender) {
    switch (gender) {
      case MALE:
        clickOn(maleButton);
        break;
      case FEMALE:
        clickOn(femaleButton);
        break;
    }
    return this;
  }

  public AccountCreationPage writeName(String text) {
    writeText(text, personalNameInput);
    return this;
  }

  public AccountCreationPage writeSurname(String text) {
    writeText(text, personalSurnameInput);
    return this;
  }

  public AccountCreationPage writeEmail(String text) {
    writeText(text, emailInput);
    return this;
  }

  public AccountCreationPage writePassword(String text) {
    writeText(text, passwordInput);
    return this;
  }


  public AccountCreationPage setDayBirthDropdown(int monthDay) {
    selectDropdownByIndex(dayBirthDropdown, 1);
    return this;
  }

  public AccountCreationPage setMonthBirthDropdown(Month month) {
    selectDropdownByIndex(monthBirthDropdown, (month.getValue()));
    return this;
  }

  public AccountCreationPage setYearBirthDropdown(int year) {
    selectDropdownByValue(yearBirthDropdown, String.valueOf(year));
    return this;
  }

  public AccountCreationPage optInForNewsletter() {
    clickOn(newsletterCheckbox);
    return this;
  }

  public AccountCreationPage optInForSpecialOffers() {
    clickOn(optInCheckbox);
    return this;
  }

  public AccountCreationPage writeAddressName(String text) {
    writeText(text, addressNameInput);
    return this;
  }

  public AccountCreationPage writeAddressSurname(String text) {
    writeText(text, addressSurnameInput);
    return this;
  }

  public AccountCreationPage writeCompany(String text) {
    writeText(text, companyInput);
    return this;
  }

  public AccountCreationPage writeAddressLine1(String text) {
    writeText(text, addressline1Input);
    return this;
  }

  public AccountCreationPage writeAddressLine2(String text) {
    writeText(text, addressline2Input);
    return this;
  }

  public AccountCreationPage writeCity(String text) {
    writeText(text, city);
    return this;
  }

  public AccountCreationPage setStateDropdown(String text) {
    selectDropdownByVisibleText(stateDropdown, text);
    return this;
  }

  public AccountCreationPage writeZipCode(String text) {
    writeText(text, zipCodeInput);
    return this;
  }

  public AccountCreationPage setCountryDropdown(AvailableRegistrationCountries country) {
    switch (country) {
      case US:
        selectDropdownByIndex(countryDropdown, 1);
        break;
      case OTHER:
        selectDropdownByIndex(countryDropdown, 0);
        break;
    }
    return this;
  }

  public AccountCreationPage writeOtherInfo(String text) {
    writeText(text, otherInfoInput);
    return this;
  }

  public AccountCreationPage writeHomePhone(String text) {
    writeText(text, homePhoneInput);
    return this;
  }

  public AccountCreationPage writeMobilePhone(String text) {
    writeText(text, mobilePhoneInput);
    return this;
  }

  public AccountCreationPage writeAlias(String text) {
    writeText(text, aliasInput);
    return this;
  }

  public MyAccountPage clickOnRegisterButton(int waitTimeout) {
    clickOn(registerButton);
    return new MyAccountPage(driver, waitTimeout);
  }

  public String getErrorText(){
    return getText(registrationErrorBox);
  }
}
