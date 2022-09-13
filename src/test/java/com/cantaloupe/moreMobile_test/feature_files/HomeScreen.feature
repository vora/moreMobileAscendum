Feature: Home Page Health Check
  As a more app user, I want see if the home page has all the elements after launching the app
  #USAT-7451

@HomeScreen
#USAT-8499, #USAT-8501m USAT-8502
  Scenario: First carousal and first header on screen
    Given user launches the application and navigates to Home page
    When the carousals should be scrollable horizontally
    When user clicks on the "initial carousel"
    And user sees if there is the "first header" displayed

  @HomeScreen
#  @SmokeTest
#USAT-8504, USAT-8505, USAT-8506, USAT-8507,
  Scenario: Scroll through carousals
    Given user launches the application and navigates to Home page
    When user sees "logo" on the screen
    Then user clicks on carousal and see's if the header is displayed accordingly:
      | first carousel  | firstHeader  |
      | second carousel | secondHeader |
      | third carousel  | thirdHeader  |
      | fourth carousel | fourthHeader |

  @HomeScreen
    #USAT-8510
  Scenario: Navigate to create account screen
    Given user launches the application and navigates to Home page and clicks on create account button
    When user sees "next button" on the screen
    And More "initial create account page" should load successfully

  @HomeScreen
     #USAT-8511
  Scenario: Navigate to sign in screen
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    Then More "signin existingaccount page" should load successfully

  @HomeScreen
    #USAT-8499, #USAT-8501m USAT-8502
  Scenario: First carousal and first header on screen
    Given user launches the application and navigates to Home page
    When the carousals should be scrollable horizontally
    When user clicks on the "initial carousel"
    And user sees if there is the "first header" displayed



