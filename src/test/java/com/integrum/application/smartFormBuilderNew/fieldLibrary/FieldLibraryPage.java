package com.integrum.application.smartFormBuilderNew.fieldLibrary;

import static com.integrum.application.utills.ConfigFile.fieldID;
import static com.integrum.application.utills.ConfigFile.fieldName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.integrum.application.base.BasePage;
import com.integrum.application.utills.Repeater;

/**
 * Created by rajender.koyyeda on 09-10-2023.
 */
public class FieldLibraryPage extends BasePage {

  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[1]")
  public WebElement CategoryEle;
  @FindBy(xpath = "//input[@name='FieldLabel']")
  public WebElement FieldLabel;
  @FindBy(xpath = "//input[@name='FieldId']")
  public WebElement FieldId;
  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[2]")
  public WebElement FieldTypeEle;

  public void createNewField(String Category, String Label, String FieldID, String FieldType) {
    waitForElementToBeClickable(saveButton);
    selectValueFromDropDown(CategoryEle, Category);
    performESCP();
    String extraString = generateRandomNumberSize(4);
    fieldName = Label.concat(extraString);
    fieldID = FieldID.concat(extraString);
    FieldLabel.sendKeys(fieldName);
    log().info("Passed fieldName as " + fieldName);
    FieldId.sendKeys(fieldID);
    log().info("Passed fieldID as " + fieldID);
    selectValueFromDropDown(FieldTypeEle, FieldType);
    saveButton.click();
    Repeater.sleep(4000);
  }
}
