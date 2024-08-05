package com.integrum.application.hooks;

import static com.integrum.application.base.BasePage.takeScreenshot;
import static com.integrum.application.utills.Browser.closeBrowser;
import com.integrum.application.utills.BrowserFactory;
import com.integrum.application.utills.ConfigFile;
import com.integrum.application.utills.LoggerClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GeneralHooks implements LoggerClass {

  public GeneralHooks() {
    System.out.println("General hook started executing to setup configurations");
    ConfigFile.setupConfiguration();
  }


  @Before(order = 0)
  public void runBrowser(Scenario scenario) {
    ConfigFile.scenarioID = scenario.getId();
    log().info("Reached to initialize the Driver from Before hook.");
    BrowserFactory.initializeDriver();
  }


  @After(order = 1000)
  public void afterFail(Scenario scenario) {
    if (scenario.isFailed()) {
      log().info("Scenario is failed hence taking screenshot from After hook.");
      takeScreenshot(scenario);
    }
  }

  @After(order = 1)
  public void closeSession(Scenario scenario) {
    closeBrowser();
    log().info("Closed the browser from After hook.");
  }
}
