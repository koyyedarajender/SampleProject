package com.integrum.application.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.integrum.application.base.BasePage;

/**
 * Created by rajender.koyyeda on 06-10-2023 .
 */
public class LoginPage extends BasePage {

  @FindBy(id = "user-id")
  private WebElement email_text_field;
  @FindBy(id = "pw-id")
  private WebElement password_text_field;
  @FindBy(xpath = "//a[@href='javascript:document.forms[0].submit();']")
  private WebElement login_button;
  @FindBy(xpath = "//a[@href='javascript:logout();']")
  private WebElement logout_button;

  public void logOut() {
    switchToLeftPane();
    waitForElementToBeClickable(logout_button);
    logout_button.click();
    log().info("Clicked on logout");
  }

  public void login(String user, String pwd) {
    openBrowser();
    fill_email_field(user);
    fill_password_field(pwd);
    clickOnLoginButton();
  }

  public void fill_email_field(String user) {
    waitForElementToBeClickable(email_text_field);
    email_text_field.clear();
    email_text_field.click();
    email_text_field.sendKeys(user);
    log().info("username passed");
  }

  public void fill_password_field(String pwd) {
    waitForElementToBeClickable(password_text_field);
    password_text_field.clear();
    password_text_field.click();
    password_text_field.sendKeys(pwd);
    email_text_field.click();
    log().info("password passed");
  }

  public void clickOnLoginButton() {
    waitForElementToBeClickable(login_button);
    login_button.click();
    log().info("login button clicked");
  }


}
