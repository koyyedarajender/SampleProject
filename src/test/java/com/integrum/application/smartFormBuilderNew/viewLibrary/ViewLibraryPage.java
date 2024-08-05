package com.integrum.application.smartFormBuilderNew.viewLibrary;

import static com.integrum.application.utills.ConfigFile.instanceName;
import static com.integrum.application.utills.ConfigFile.sectionID;
import static com.integrum.application.utills.ConfigFile.sectionTitleName;
import static com.integrum.application.utills.ConfigFile.viewID;
import static com.integrum.application.utills.ConfigFile.viewTitleName;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.integrum.application.base.BasePage;
import com.integrum.application.utills.Repeater;

/**
 * Created by rajender.koyyeda on 10-10-2023.
 */
public class ViewLibraryPage extends BasePage {

  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[1]")
  public WebElement CategoryEle;
  @FindBy(xpath = "//input[@name='ViewTitle']")
  public WebElement viewTitleEle;
  @FindBy(xpath = "//input[@name='ViewId']")
  public WebElement viewIdEle;
  @FindBy(id = "actList")
  public WebElement actionsDest;
  @FindBy(id = "secList")
  public WebElement columnsDest;
  @FindBy(id = "NewDoc")
  public WebElement NewDocAction;
  @FindBy(xpath = "//font[contains(text(),'Your request has been processed')]")
  public WebElement successMsg;
  @FindBy(xpath = "//font[contains(text(),'here')]")
  public WebElement clickHereEle;


  public void viewLibraryPage(String formTemplateTitleName, String title, String viewIDVal) {
    waitForElementToBeClickable(saveButton);
    selectValueFromDropDown(CategoryEle, formTemplateTitleName);
    performESCP();
    String extraString = generateRandomNumberSize(4);
    viewTitleName = title.concat(extraString);
    viewID = viewIDVal.concat(extraString);
    viewTitleEle.sendKeys(viewTitleName);
    log().info("Passed viewTitleName as " + viewTitleName);
    viewIdEle.sendKeys(viewID);
    log().info("Passed viewID as " + viewID);
    Repeater.sleep(3000);
    Assert.assertTrue(getBrowser().findElement(By.xpath("//h3[@title='" + sectionTitleName + "']")).isDisplayed());
    dragAndDrop(NewDocAction, actionsDest);

    List<WebElement> sourceSections =
        getBrowser().findElements(By.xpath("//div[@sid='" + sectionID + "']"));
    for (int i = 1; i < sourceSections.size(); i++) {
      dragAndDrop(sourceSections.get(i), columnsDest);
      Repeater.sleep(2000);
    }
    saveButton.click();
    Repeater.sleep(4000);
    if (instanceName.equalsIgnoreCase("grandmaster") || instanceName.equalsIgnoreCase("cocaCola")) {
      Assert.assertTrue(successMsg.isDisplayed());
      Assert.assertTrue(successMsg.getText().trim().contains("Your request has been processed"));
      Assert.assertTrue(clickHereEle.isDisplayed());
      clickHereEle.click();
      Repeater.sleep(2000);
    }
  }
}
