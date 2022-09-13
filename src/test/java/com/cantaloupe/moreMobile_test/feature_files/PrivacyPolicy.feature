Feature: PrivacyPolicy
  As a more app user, I want see if to navigate to the Privacy Policy screen and verify the content

  @PrivacyPolicy
  Scenario: Navigation to Privacy Policy screen and verify content
  Given user launches the application and navigates to respective page by clicking on "privacy policy link" and entering valid email and password
    Then More "privacy policy page" should load successfully
    And user verifies the privacy policy content on the screen

  @PrivacyPolicy
  Scenario: Navigation back to dahboard screen
    Given user launches the application and navigates to respective page by clicking on "privacy policy link" and entering valid email and password
    Then More "privacy policy page" should load successfully
    When user clicks on the "back to dashboard button"
    Then More "dashboard page" should load successfully

  @PrivacyPolicy
  Scenario: Navigate back to home screen
    Given user launches the application and navigates to respective page by clicking on "privacy policy link" and entering valid email and password
    When More "privacy policy page" should load successfully
    And user clicks on back to dashboard button and is able to navigate back to the screen

