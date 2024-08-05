package com.integrum.application.base;


import static com.integrum.application.utills.ConfigFile.fieldCategoryName;
import static com.integrum.application.utills.ConfigFile.fieldID;
import static com.integrum.application.utills.ConfigFile.fieldName;
import static com.integrum.application.utills.ConfigFile.formTemplateCategoryName;
import static com.integrum.application.utills.ConfigFile.formTemplateID;
import static com.integrum.application.utills.ConfigFile.formTemplateTitleName;
import static com.integrum.application.utills.ConfigFile.sectionCategoryName;
import static com.integrum.application.utills.ConfigFile.sectionID;
import static com.integrum.application.utills.ConfigFile.sectionTitleName;
import static com.integrum.application.utills.ConfigFile.viewID;
import static com.integrum.application.utills.ConfigFile.viewTitleName;
import com.integrum.application.utills.Repeater;
import io.cucumber.java.en.And;

public class BaseStepDefinition extends BasePage {

  BasePage basePage = new BasePage();

  @And("switch to {string} frame")
  public static void switchToFrame(String typeOfFrame) {
    switch (typeOfFrame.trim()) {
      case "leftPane":
        switchToLeftPane();
        break;
      case "mainMenu":
        switchToMainMenu();
        break;
      default:
        System.out.println("pageName is not provided to validate ");
    }

  }

  @And("close the browser")
  public void closeTheBrowser() {
    closeBrowser();
    log().info("Closed the browser");
  }

  @And("wait for some time")
  public void waitForSomeTime() {
    Repeater.sleep(9000);
  }

  @And("scroll total down")
  public void scrollTotalDown() {
    scrollTotalDown();
  }

  @And("refresh the page")
  public void refreshThePage() throws InterruptedException {
    refreshPage();
  }

  @And("switch to {string} windowHandle")
  public void switchToWindowHandle(String number) {
    switchToWindowIndex(Integer.parseInt(number));
  }

  @And("click on New option")
  public void clickOnNewOption() {
    clickNewElement();
  }

  @And("reload the page")
  public void reloadThePage() {
    clickOnReloadIcon();
  }

  @And("search and verify the {string} created record")
  public void searchAndVerifyTheCreatedRecord(String type) {
    String value = "";
    String valueID = "";
    String categoryFieldValue = "";
    switch (type.trim()) {
      case "fieldLibrary":
        value = fieldName;
        valueID = fieldID;
        categoryFieldValue = fieldCategoryName;
        searchAndVerifyTheCreatedRecord(categoryFieldValue, value, valueID);
        break;
      case "sectionLibrary":
        value = sectionTitleName;
        valueID = sectionID;
        categoryFieldValue = sectionCategoryName;
        searchAndVerifyTheCreatedRecord(categoryFieldValue, value, valueID);
        break;
      case "formTemplate":
        categoryFieldValue = formTemplateCategoryName;
        value = formTemplateTitleName;
        valueID = formTemplateID;
        searchAndVerifyTheCreatedRecord(categoryFieldValue, value, valueID);
        break;
      case "viewLibrary":
        categoryFieldValue = "";
        value = viewTitleName;
        valueID = viewID;
        switchToMainMenu();
        clickOnReloadIcon();
        Repeater.sleep(3000);
        verifyRecords(value, valueID);
        break;
      default:
        log().info("type is not provided to validate ");
    }

  }

  @And("click on {string} button")
  public void clickOnButton(String buttonName) {
    clickOnTheButton(buttonName);
  }
}
