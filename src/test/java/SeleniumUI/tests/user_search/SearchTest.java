package SeleniumUI.tests.user_search;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SeleniumUI.pages.LandingPage;
import SeleniumUI.tests.test_base.TestBase;

public class SearchTest extends TestBase {

  private LandingPage landingPage;


  @BeforeClass
  private void loadObjects() {
    landingPage = new LandingPage(driver, 10);
  }


  @Test
  private void searchForSomething() {
    assertThat(landingPage.searchFor("Dress", 20)
        .getNumberOfSearchResults())
        .isNotZero();

  }


}
