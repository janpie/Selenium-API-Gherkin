package SeleniumUI.pages.base;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  protected WebDriver driver;
  WebDriverWait wait;

  protected BasePage(WebDriver driver, int waitTimeout) {
    this.driver = driver;
    wait = new WebDriverWait(driver, waitTimeout);
  }

  protected WebElement waitForVisibility(WebElement element) {
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected WebElement waitForClickable(WebElement element) {
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  protected WebElement writeText(String text, WebElement element) {
    waitForVisibility(element).clear();
    element.sendKeys(text);
    return element;
  }

  protected WebElement clickOn(WebElement element) {
    waitForClickable(element).click();
    return element;
  }

  protected String getText(WebElement element){
    return waitForVisibility(element).getText();
  }

  protected Select selectDropdownByIndex(WebElement element, int index) {
    Select dropdown = new Select(element);
    dropdown.selectByIndex(index);
    return dropdown;
  }

  protected Select selectDropdownByVisibleText(WebElement element, String text) {
    Select dropdown = new Select(element);
    dropdown.selectByVisibleText(text);
    return dropdown;
  }

  protected Select selectDropdownByValue(WebElement element, String value) {
    Select dropdown = new Select(element);
    dropdown.selectByValue(value);
    return dropdown;
  }

  protected List<WebElement> waitForVisibilityOfAll(List<WebElement> listOfWebElements){
    return wait.until(ExpectedConditions.visibilityOfAllElements(listOfWebElements));
  }
}
