package com.integrum.application.smartFormBuilderNew.sectionLibrary;

import static com.integrum.application.utills.ConfigFile.fieldCategoryName;
import static com.integrum.application.utills.ConfigFile.fieldID;
import static com.integrum.application.utills.ConfigFile.sectionID;
import static com.integrum.application.utills.ConfigFile.sectionTitleName;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.integrum.application.base.BasePage;
import com.integrum.application.utills.Repeater;

/**
 * Created by rajender.koyyeda on 09-10-2023.
 */
public class SectionLibraryPage extends BasePage {

  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[1]")
  public WebElement CategoryEle;
  @FindBy(xpath = "//input[@name='SectionTitle']")
  public WebElement SectionTitle;
  @FindBy(xpath = "//input[@name='SectionId']")
  public WebElement SectionIdEle;
  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[2]")
  public WebElement FieldTypeEle;
  @FindBy(xpath = "(//div[@class='secbody ui-sortable'])[1]")
  public WebElement destinationColumn;


  public void createNewSection(String sectionCategoryName, String Title, String SectionFieldID) {
    waitForElementToBeClickable(saveButton);
    selectValueFromDropDown(CategoryEle, sectionCategoryName);
    performESCP();
    String extraString = generateRandomNumberSize(4);
    sectionTitleName = Title.concat(extraString);
    sectionID = SectionFieldID.concat(extraString);
    SectionTitle.sendKeys(sectionTitleName);
    log().info("Passed sectionTitleName as " + sectionTitleName);
    SectionIdEle.sendKeys(sectionID);
    log().info("Passed sectionID as " + sectionID);



    Repeater.sleep(2000);
    List<WebElement> tabList =
        getBrowser().findElements(By.xpath("(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])"));
    int num = tabList.size() - 1;
    tabList.get(num).click();
    Repeater.sleep(5000);
    List<WebElement> sourceSections =
        getBrowser().findElements(By.xpath("//span[contains(text(),'" + fieldCategoryName + "')]"));
    for (int i = 0; i < sourceSections.size(); i++) {
      if (sourceSections.get(i).getText().trim().equalsIgnoreCase(fieldCategoryName)) {
        sourceSections.get(i).click();
        Repeater.sleep(4000);
        log().info("CLicked on sectionCategoryName element " + sourceSections.get(i).getText().trim());
        break;
      }
    }
    Repeater.sleep(3000);
    WebElement sourceEle =
        getBrowser().findElement(By.xpath("//div[@id='" + fieldID + "']"));
    dragAndDrop(sourceEle, destinationColumn);

    saveButton.click();
    Repeater.sleep(4000);
  }
}
