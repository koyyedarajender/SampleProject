package com.integrum.application.smartFormBuilderNew.viewLibrary;

import static com.integrum.application.utills.ConfigFile.formTemplateTitleName;
import java.util.Map;
import com.integrum.application.base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

/**
 * Created by rajender.koyyeda on 10-10-2023.
 */
public class ViewLibraryStepDefinition extends BasePage {
  ViewLibraryPage viewLibraryPage = new ViewLibraryPage();

  @And("create a new viewLibrary with below data")
  public void createANewViewLibraryWithBelowData(DataTable shipDetails) {
    for (Map<String, String> data : shipDetails.asMaps(String.class, String.class)) {
      String category = "";
      if (data.get("viewLibraryCategory").equalsIgnoreCase("dynamic")) {
        category = formTemplateTitleName;
      } else {
        category = data.get("viewLibraryCategory");
      }
      String title = data.get("viewTitle");
      String viewID = data.get("viewID");
      viewLibraryPage.viewLibraryPage(category, title, viewID);
    }
  }
}
