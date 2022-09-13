Feature: Sign in Sign out
  As a more app user, I want to sign in to the app so that I see my profile
  As a more app user, I want to sign out of the app so that my profile details are not seen
#USAT-6086

@SignInSignOut
  #@USAT-8562
  Scenario: Sign out of application
    #Given user launches the application and navigates to dashboard page by entering valid email and password
    Given user launches the application and navigates to dashboard screen by entering valid email and password
    When user clicks on the "profile link"
    And More "update profile page" should load successfully
    Then user clicks on the "sign out link"
    And More "home page" should load successfully

  @SignInSignOut
  #@USAT-8548
  Scenario: Navigation through already have an account link
    Given user launches the application and navigates to Home page
    When user clicks on the "already have an account link"
    Then user should be navigating to the screen until the sign in page

  @SignInSignOut
 # @USAT-8549
  Scenario: Navigation to sign in screen through email
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    Then user enters "cntlp1@yopmail.com" in the "email input field"

  @SignInSignOut
    #USAT-8551
  Scenario:  Blank or invalid email error
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    Then user enters " " in the "email input field"
    And user enters "dfdsf" in the "password input field"
    Then user should see "Please enter your email." error for "blank or invalid email error"

  @SignInSignOut
  #@USAT-8552
  Scenario: Masking password field
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    Then user enters "Pass@123" in the "password input field"
    And user sees that the "password input field" is masked

  @SignInSignOut
 # @USAT-8553
  Scenario: Unmask password field
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    And user enters "Pass@123" in the "password input field"
    And user sees that the "password input field" is masked
    Then user clicks on the "password show link"
    And user sees that the "password input field" is not masked

  @SignInSignOut
 # @USAT-8554
  Scenario:  Blank error for password field
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    Then user focus on password field and moves out of it
    And user should see "Please enter your password." error for "blank password error"

  @SignInSignOut
 # @USAT-8555
  Scenario: Sign in button disabled mode
    Given user launches the application and navigates to sign in screen through different options page
    When user sees "sign in header" on the screen
    Then user verifies the data for email and password field is blank
    Then the "sign in button" will not be in enabled mode

  @SignInSignOut
#  @SmokeTest
  #@USAT-8556
  Scenario: Login with valid email and password
    Given user launches the application and navigates to sign in screen through different options page
    When user enters a valid email and password in respective field
    Then user clicks on the "sign in button"
    And More "dashboard page" should load successfully

  @SignInSignOut
  #@USAT-8557
  Scenario: Invalid login credentials
    Given user launches the application and navigates to sign in screen through different options page
    When user enters a invalid "cntlp1@yopmail.com" in "jgfghfg" field
    And user clicks on the "sign in button"
    Then user see's an alert pop up displaying on the screen

  @SignInSignOut
 # @USAT-8558
  Scenario: Navigation back to home csreen
    Given user launches the application and navigates to sign in screen through different options page
    When user clicks on the "sign in header"
    Then user sees if he is navigated back to home page from sign in page by clicking - "back home link" or "back to login options link"

  @SignInSignOut
 # @USAT-8559
  Scenario:  Navigation to forgot password page
    Given user launches the application and navigates to sign in screen through different options page
    When user clicks on the "forgot password link"
    Then More "forgot password page" should load successfully
    And user sees "forgot password header" on the screen

  @SignInSignOut
  #@USAT-8560
  Scenario:  Navigating back will erase entered data
    Given user launches the application and navigates to sign in screen through different options page
    When user enters a valid email and password in respective field
    Then user sees if he is navigated back to home page from sign in page by clicking - "back home link" or "back to login options link"
    And user launches the application and to navigate to sign in page
    And user verifies the data for email and password field is blank
    Then the "sign in button" will not be in enabled mode

  @SignInSignOut
 # @USAT-8561
  Scenario: Navigation to update profile screen
    Given user launches the application and navigates to dashboard screen by entering valid email and password
    When user clicks on the "profile link"
    Then More "update profile page" should load successfully









