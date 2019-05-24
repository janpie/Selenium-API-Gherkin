package SeleniumUI.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import SeleniumUI.pages.SearchResultsPage;
import SeleniumUI.pages.SignInPage;
import SeleniumUI.pages.base.BasePage;

public abstract class CommonUpperModulePage extends BasePage {

  @FindBy(css = "a.login")
  private WebElement signInButton;

  @FindBy(id="search_query_top")
  private WebElement searchBar;

  @FindBy(css="button.btn.btn-default.button-search")
  private WebElement submitSearchButton;

  protected CommonUpperModulePage(WebDriver driver, int waitTimeout) {
    super(driver, waitTimeout);
  }

  public SearchResultsPage searchFor(String text, int waitTimeout) {
    writeText(text, searchBar);
    clickOn(submitSearchButton);
    return new SearchResultsPage(driver, waitTimeout);
  }

  public SignInPage goToSignInPage(int waitTimeout){
    clickOn(signInButton);
    return new SignInPage(driver, waitTimeout);
  }
}
