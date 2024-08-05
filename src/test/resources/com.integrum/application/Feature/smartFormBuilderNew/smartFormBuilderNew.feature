#Author: RajenderKoyyeda
#Feature: SmartFormsBuilderNew
#Developed By : RajenderKoyyeda

@regression @smartForms @test
Feature: SmartFormsBuilderNew - Verify smartFormBuilderNew scenarios

  Scenario: Verify smartFormBuilderNew functionality
    Given login to integrum application
    And wait for some time
    When Navigated to "smartFormBuilderNew" page
    And Navigated to "fieldLibrary" sub page
    And click on New option
    And switch to "1" windowHandle
    And create a new field library with below data
      | Category | Label     | FieldID      | FieldType |
      | dynamic  | AUTOField | AUTOField_ID | Text      |
    And switch to "0" windowHandle
    Then search and verify the "fieldLibrary" created record

    And switch to "leftPane" frame
    And Navigated to "sectionLibrary" sub page
    And click on "new" button
    And switch to "1" windowHandle
    And create a new section library with below data
      | categorySection | title       | sectionID      |
      | dynamic         | AUTOSection | AUTOSection_ID |
    And switch to "0" windowHandle
    And search and verify the "sectionLibrary" created record

    And switch to "leftPane" frame
    And Navigated to "formTemplate" sub page
    And click on "new" button
    And switch to "1" windowHandle
    And create a new formTemplate with below data
      | formTempCategory | title            | templateID          | formName | layout    |
      | dynamic          | AUTOFormTemplate | AUTOFormTemplate_ID | AUTOForm | Accordion |
  #  And select below value for workflow wizard
  #    | formWorkFlowType        |
  #    | Form & Section Workflow |
    And click on "save" button
    And click on "close" button
    And switch to "0" windowHandle
    And search and verify the "formTemplate" created record

    And switch to "leftPane" frame
    And Navigated to "viewLibrary" sub page
    And click on "new" button
    And switch to "1" windowHandle
    And create a new viewLibrary with below data
      | viewLibraryCategory | viewTitle | viewID      |
      | dynamic             | AUTOView  | AUTOView_ID |
    And switch to "0" windowHandle
    And search and verify the "viewLibrary" created record
    And logout from integrum application
