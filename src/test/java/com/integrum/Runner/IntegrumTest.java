package com.integrum.Runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = {"classpath:com.integrum/application"},
    glue = {"com.integrum.application"},
    plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.html", "junit:target/cucumber-reports/cucumber.xml"},
    tags = "@login"
)
public class IntegrumTest extends AbstractTestNGCucumberTests {
  @Override
  @DataProvider(parallel = false)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
