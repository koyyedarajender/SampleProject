package com.integrum.application.navigate;

import static com.integrum.application.utills.ConfigFile.applicationUrl;
import static com.integrum.application.utills.ConfigFile.propertiesAsMap;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.integrum.application.base.BasePage;
import com.integrum.application.utills.Repeater;

/**
 * Created by rajender.koyyeda on 06-10-2023 .
 */
public class NavigatePage extends BasePage {

  @FindBy(xpath = "//a[@href='javascript:MenuExpand();']")
  public WebElement expandAllList;
  @FindBy(xpath = "//a[contains(text(),'Smart Form Builder (New)')]")
  public WebElement SmartFormBuilderNew;
  @FindBy(xpath = "//a[@href='/tmrdev/emsearch.nsf/fs_MSN?OpenFrameSet']")
  public WebElement mainSystemNavigation;
  @FindBy(xpath = "//a[contains(text(),'Field Library')][@target='main']")
  public WebElement fieldLibraryEle;
  @FindBy(xpath = "//a[contains(text(),'Section Library')][@target='main']")
  public WebElement sectionLibraryEle;
  @FindBy(xpath = "//a[contains(text(),'Form Template')][@target='main']")
  public WebElement formTemplateEle;
  @FindBy(xpath = "//a[contains(text(),'View Library')][@target='main']")
  public WebElement viewLibraryEle;


  public void navigateToSubPage(String pageName) {
    log().info("Reached to goto subpage " + pageName);
    switch (pageName.trim()) {
      case "fieldLibrary":
        waitForElementToBeAvailable(fieldLibraryEle);
        log().info("Verified the landed page successfully " + fieldLibraryEle.getText().trim());
        fieldLibraryEle.click();
        Repeater.sleep(3000);
        break;
      case "sectionLibrary":
        waitForElementToBeAvailable(sectionLibraryEle);
        log().info("Verified the landed page successfully " + sectionLibraryEle.getText().trim());
        sectionLibraryEle.click();
        Repeater.sleep(3000);
        break;
      case "formTemplate":
        waitForElementToBeAvailable(formTemplateEle);
        log().info("Verified the landed page successfully " + formTemplateEle.getText().trim());
        formTemplateEle.click();
        Repeater.sleep(3000);
        break;
      case "viewLibrary":
        waitForElementToBeAvailable(viewLibraryEle);
        log().info("Verified the landed page successfully " + viewLibraryEle.getText().trim());
        viewLibraryEle.click();
        Repeater.sleep(3000);
        break;
      default:
        log().info("pageName is not provided to validate ");
    }
  }

  public void navigateToPage(String pageName) {
    switchToLeftPane();
    waitForElementToBeClickable(expandAllList);
    expandAllList.click();
    expandAllList.click();
    log().info("Clicked on Expand all");
    List<WebElement> generalOptions =
        getBrowser().findElements(By.xpath("//div[@id='my_menu']//following::span[contains(text(),'General')]"));
    if (generalOptions.size() == 1) {
      generalOptions.get(0).click();
      Repeater.sleep(1000);
      log().info("Clicked on General option");
      mainSystemNavigation.click();
      log().info("Clicked on main System Navigation option");
      expandAllList.click();
      expandAllList.click();
    }
    Repeater.sleep(1000);

    switch (pageName.trim()) {
      case "smartFormBuilderNew":
        waitForElementToBeAvailable(SmartFormBuilderNew);
        log().info("Verified the landed page successfully " + SmartFormBuilderNew.getText().trim());
        SmartFormBuilderNew.click();
        Repeater.sleep(4000);
        break;
      default:
        log().info("pageName is not provided to validate ");
    }
  }

  public void navigateToNewtab(String pageName) {
    ((JavascriptExecutor) getBrowser()).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<String>(getBrowser().getWindowHandles());
    getBrowser().switchTo().window(tabs.get(1));
    getBrowser().get(applicationUrl + propertiesAsMap.get(pageName.trim()));
    log().info("Navigated to sub module of : " + applicationUrl + propertiesAsMap.get(pageName.trim()));
    Repeater.sleep(5000);
  }
}
