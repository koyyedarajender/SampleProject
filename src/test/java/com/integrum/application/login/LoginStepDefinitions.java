package com.integrum.application.login;

import static com.integrum.application.utills.ConfigFile.password;
import static com.integrum.application.utills.ConfigFile.userName;
import com.integrum.application.base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class LoginStepDefinitions extends BasePage {

  LoginPage loginPage = new LoginPage();

  @Given("login to integrum application")
  public void loginToIntegrumApplication() {
    log().info("Reached to login process");
    loginPage.login(userName, password);
  }

  @And("logout from integrum application")
  public void logoutFromIntegrumApplication() {
    loginPage.logOut();
  }
}
