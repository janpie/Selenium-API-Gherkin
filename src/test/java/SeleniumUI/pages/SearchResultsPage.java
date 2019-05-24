package SeleniumUI.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumUI.pages.common.CommonUpperModulePage;

public class SearchResultsPage extends CommonUpperModulePage {

  @FindBy(xpath = "//ul[@class='product_list grid row']/li")
  List<WebElement> searchResultsList;


  public SearchResultsPage(WebDriver driver, int waitTimeout) {
    super(driver, waitTimeout);
    PageFactory.initElements(driver, this);
  }

  public int getNumberOfSearchResults() {
    return waitForVisibilityOfAll(searchResultsList).size();
  }
}
