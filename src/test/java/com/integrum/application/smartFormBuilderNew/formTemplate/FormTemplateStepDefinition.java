package com.integrum.application.smartFormBuilderNew.formTemplate;

import static com.integrum.application.utills.ConfigFile.formTemplateCategoryName;
import java.util.Map;
import com.integrum.application.base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

/**
 * Created by rajender.koyyeda on 09-10-2023.
 */
public class FormTemplateStepDefinition extends BasePage {
  FormTemplatePage formTemplatePage = new FormTemplatePage();


  @And("create a new formTemplate with below data")
  public void createANewFormTemplateWithBelowData(DataTable shipDetails) {
    for (Map<String, String> data : shipDetails.asMaps(String.class, String.class)) {
      String category = "";
      if (data.get("formTempCategory").equalsIgnoreCase("dynamic")) {
        category = formTemplateCategoryName;
      } else {
        category = data.get("formTempCategory");
      }
      String title = data.get("title");
      String templateID = data.get("templateID");
      String formName = data.get("formName");
      String layout = data.get("layout");
      formTemplatePage.createNewFormTemplate(category, title, templateID, formName, layout);
    }
  }

  @And("select below value for workflow wizard")
  public void selectBelowValueForWorkflowWizard(DataTable shipDetails) {
    for (Map<String, String> data : shipDetails.asMaps(String.class, String.class)) {
      String formWorkFlowType = data.get("formWorkFlowType");
      formTemplatePage.formWorkFlowType(formWorkFlowType);
    }

  }
}
