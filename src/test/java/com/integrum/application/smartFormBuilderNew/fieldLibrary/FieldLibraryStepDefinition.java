package com.integrum.application.smartFormBuilderNew.fieldLibrary;

import static com.integrum.application.utills.ConfigFile.fieldCategoryName;
import java.util.Map;
import com.integrum.application.base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

/**
 * Created by rajender.koyyeda on 09-10-2023.
 */
public class FieldLibraryStepDefinition extends BasePage {
  FieldLibraryPage fieldLibraryPage = new FieldLibraryPage();


  @And("create a new field library with below data")
  public void createANewFieldLibraryWithBelowData(DataTable shipDetails) {
    for (Map<String, String> data : shipDetails.asMaps(String.class, String.class)) {
      String category = "";
      if (data.get("Category").equalsIgnoreCase("dynamic")) {
        category = fieldCategoryName;
      } else {
        category = data.get("Category");
      }
      String Label = data.get("Label");
      String FieldID = data.get("FieldID");
      String FieldType = data.get("FieldType");
      fieldLibraryPage.createNewField(category, Label, FieldID, FieldType);
    }
  }
}
