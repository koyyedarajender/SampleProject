package com.integrum.application.navigate;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


/**
 * Created by rajender.koyyeda on 06-10-2023.
 */


public class NavigateStepDefinitions {

  NavigatePage navigatePage = new NavigatePage();

  @When("Navigated to {string} page")
  public void navigatedToPage(String pageName) {
    navigatePage.navigateToPage(pageName);
  }


  @And("Navigated to {string} page in new tab")
  public void navigatedToPageInNewTab(String pageName) {
    navigatePage.navigateToNewtab(pageName);
  }

  @And("Navigated to {string} sub page")
  public void navigatedToSubPage(String pageName) {
    navigatePage.navigateToSubPage(pageName);
  }
}
