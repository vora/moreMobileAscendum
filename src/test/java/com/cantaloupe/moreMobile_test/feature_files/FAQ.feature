Feature: FAQ
  As a more app user, I want see if to navigate to the FAQ page to get my queries clarified
  #@USAT-7987

  @FAQ
  #@USAT-8542
#  @SmokeTest
  Scenario: Navigation to FAQ screen
    Given user launches the application and navigates to dashboard page to verify FAQ by entering valid email and password
    When user clicks on the "faq link"
    Then More "faq page" should load successfully
    And user sees "first question" on the screen

  @FAQ
#  @USAT-8543
  Scenario: Content on FAQ page
    Given user launches the application and navigates to dashboard page to verify FAQ by entering valid email and password
    When user clicks on the "faq link"
    Then More "faq page" should load successfully
    And user sees the appropriate question and answers on the screen
      | First Question  | firstQuestion  |
      | First Answer    | firstAnswer    |
      | Second Question | secondQuestion |
      | Second answer   | secondAnswer   |
      | Third Question  | thirdQuestion  |
      | Third Answer    | thirdAnswer    |
      | Fourth Question | fourthQuestion |
      | Fourth answer   | fourthAnswer   |
      | Fifth Question  | fifthQuestion  |
      | Fifth Answer    | fifthAnswer    |

  @FAQ
#  @USAT-8544
  Scenario: Navigation back to Home page
    Given user launches the application and navigates to dashboard page to verify FAQ by entering valid email and password
    When user clicks on the "faq link"
    Then More "faq page" should load successfully
    And user clicks on the "home link"
    Then More "dashboard page" should load successfully