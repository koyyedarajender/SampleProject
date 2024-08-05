package com.integrum.application.smartFormBuilderNew.sectionLibrary;

import static com.integrum.application.utills.ConfigFile.sectionCategoryName;
import java.util.Map;
import com.integrum.application.base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

/**
 * Created by rajender.koyyeda on 09-10-2023.
 */
public class SectionLibraryStepDefinition extends BasePage {
  SectionLibraryPage sectionLibraryPage = new SectionLibraryPage();

  @And("create a new section library with below data")
  public void createANewSectionLibraryWithBelowData(DataTable shipDetails) {
    for (Map<String, String> data : shipDetails.asMaps(String.class, String.class)) {
      String category = "";
      if (data.get("categorySection").equalsIgnoreCase("dynamic")) {
        category = sectionCategoryName;
      } else {
        category = data.get("categorySection");
      }
      String Title = data.get("title");
      String SectionFieldID = data.get("sectionID");
      sectionLibraryPage.createNewSection(category, Title, SectionFieldID);
    }
  }
}
