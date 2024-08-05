#Author: RajenderKoyyeda
#Feature: login
#Developed By : RajenderKoyyeda

@regression @login
Feature: LOGIN - Verify login scenarios

  Scenario: Verify login functionality
    Given login to integrum application
    When wait for some time
    Then logout from integrum application