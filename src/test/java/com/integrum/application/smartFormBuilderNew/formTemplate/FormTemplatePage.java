package com.integrum.application.smartFormBuilderNew.formTemplate;

import static com.integrum.application.utills.ConfigFile.formTemplateID;
import static com.integrum.application.utills.ConfigFile.formTemplateTitleName;
import static com.integrum.application.utills.ConfigFile.sectionCategoryName;
import static com.integrum.application.utills.ConfigFile.sectionID;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.integrum.application.base.BasePage;
import com.integrum.application.utills.Repeater;

/**
 * Created by rajender.koyyeda on 09-10-2023.
 */
public class FormTemplatePage extends BasePage {

  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[1]")
  public WebElement CategoryEle;
  @FindBy(xpath = "//input[@name='TemplateTitle']")
  public WebElement TemplateTitleEle;
  @FindBy(xpath = "//input[@name='TemplateId']")
  public WebElement TemplateIdEle;
  @FindBy(xpath = "(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[14]")
  public WebElement tabList;
  @FindBy(xpath = "(//div[@class='secbody ui-sortable ui-accordion ui-widget ui-helper-reset'])[1]")
  public WebElement destinationSection;
  @FindBy(xpath = "//select[@name='FormWFType']")
  public WebElement FormWFTypeEle;
  @FindBy(xpath = "//input[@name='FormName']")
  public WebElement formNameEle;
  @FindBy(xpath = "(//select[@name=\"TemplateLayout\"]/following::button)[1]")
  public WebElement TemplateLayoutEle;

  public void formWorkFlowType(String formWorkFlowType) {
    waitForElementToBeClickable(workflowWizardButton);
    workflowWizardButton.click();
    Repeater.sleep(3000);
    switchToWindowIndex(2);
    selectValueFromDropDown(FormWFTypeEle, formWorkFlowType);
    saveButton.click();
    Repeater.sleep(3000);
    switchToWindowIndex(1);
  }

  public void createNewFormTemplate(String formTemplateCategoryName, String title, String templateID, String formName, String layout) {
    waitForElementToBeClickable(saveButton);
    selectValueFromDropDown(CategoryEle, formTemplateCategoryName);
    performESCP();
    String extraString = generateRandomNumberSize(4);
    formTemplateTitleName = title.concat(extraString);
    formTemplateID = templateID.concat(extraString);
    TemplateTitleEle.sendKeys(formTemplateTitleName);
    log().info("Passed formTemplateTitleName as " + formTemplateTitleName);
    TemplateIdEle.sendKeys(formTemplateID);
    log().info("Passed formTemplateID as " + formTemplateID);
    formNameEle.sendKeys(formName.concat(extraString));
    selectValueFromDropDown(TemplateLayoutEle, layout);
    Repeater.sleep(2000);
    List<WebElement> tabList =
        getBrowser().findElements(By.xpath("(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])"));

    int num = tabList.size() - 1;
    tabList.get(num).click();
    Repeater.sleep(3000);
   /* sectionCategoryName="Arran Test";
    sectionID="AUTOSection_ID1916";*/
    List<WebElement> sourceSections =
        getBrowser().findElements(By.xpath("//span[contains(text(),'" + sectionCategoryName + "')]"));
    for (int i = 0; i < sourceSections.size(); i++) {
      if (sourceSections.get(i).getText().trim().equalsIgnoreCase(sectionCategoryName)) {
        sourceSections.get(i).click();
        Repeater.sleep(4000);
        log().info("CLicked on sectionCategoryName element " + sourceSections.get(i).getText().trim());
        break;
      }
    }
    Repeater.sleep(3000);
    WebElement sourceEle =
        getBrowser().findElement(By.xpath("//div[@id='" + sectionID + "']"));
    dragAndDrop(sourceEle, destinationSection);
    Repeater.sleep(3000);
  }
}
