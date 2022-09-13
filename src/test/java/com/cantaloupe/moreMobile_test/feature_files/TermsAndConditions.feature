Feature: Terms And Condition
  As a more app user, I want see if to navigate to the Terms And Condition screen and verify the content

  @TermsAndConditions
  Scenario: Navigation to Terms And Condition screen and verify content
  Given user launches the application and navigates to respective page by clicking on "terms and condition link" and entering valid email and password
    Then More "terms and condition page" should load successfully
    And user verifies the terms and condition content on the screen

  @TermsAndConditions
  Scenario: Navigation back to dahboard screen
    Given user launches the application and navigates to respective page by clicking on "terms and condition link" and entering valid email and password
    Then More "terms and condition page" should load successfully
    When user clicks on the "back to dashboard button"
    Then More "dashboard page" should load successfully

  @TermsAndConditions
  Scenario: Navigate back to home screen
    Given user launches the application and navigates to respective page by clicking on "terms and condition link" and entering valid email and password
    When More "terms and condition page" should load successfully
    And user clicks on back to dashboard button and is able to navigate back to the screen

#  Scenario: Navigate to production website
#    Given user launches the application and navigates to respective page by clicking on "privacy policy link" and entering valid email and password
#    When More "privacy policy page" should load successfully
#    And user verifies if he is able to navigate to appropriate page by clicking on the "sixth link"
#
#
#
