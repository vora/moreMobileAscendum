Feature: Forgot Password
  As a more app user, I want to rest my password so that I am able to login with the new updated password
  #USAT-7983, USAT-6091

##USAT-8571, USAT-8583
#  Scenario Outline: Update password functionality
#    Given user navigates to create new password page
#    When user enters "<valid password>" and "<valid confirm password>" in password and confirm password fields
#    Then user clicks on the "update password button"
#    And user sees "your password is updated text" on the screen
#
#   Examples:
#      | valid password | valid confirm password |
#      | Pass@123       | Pass@123               |
#

  @ForgotPassword
#  @SmokeTest
       #USAT-8587
  Scenario: Redundant link functionality
    Given user navigates to create new password page
    When user enters "Pass@123" and "Pass@123" in password and confirm password fields
    Then user clicks on the "update password button"
    And user sees "passcode is expired alert pop up" on the screen

  @ForgotPassword
    #USAT-8566, USAT-8567
  Scenario: Forgot password flow
    Given user launches the application and to navigate to forgot password page by entering "cntlp2@yopmail.com"
    When user clicks on the "send me a reset link"
    Then More "forgot password message page" should load successfully

  @ForgotPassword
    #USAT-8568
  Scenario: Send me a link button status
    Given user launches the application and to navigate to sign in page
    When user clicks on the "forgot password link"
    Then user does not enter any data in the email input field
    And user see's that the send me a rest link is in disabled mode


  @ForgotPassword
    #USAT-8573, 8574
  Scenario: Mask and unmask password field
    Given user navigates to create new password page
    When user enters "Pass@123" in the "password input field"
    And user clicks on the "password show link"
    Then user sees that the "password input field" is not masked
    And user clicks on the "password hide link"
    Then user sees that the "password input field" is masked


  @ForgotPassword
    #USAT-8575, USAT-8576
  Scenario: Mask and unmask confirm password field
    Given user navigates to create new password page
    When user enters "Pass@123" in the "confirm password input field"
    And user clicks on the "confirm password show link"
    Then user sees that the "confirm password input field" is not masked
    And user clicks on the "confirm password hide link"
    Then user sees that the "confirm password input field" is masked


  @ForgotPassword
    #USAT-8569
  Scenario: Navigation back to home screen
    Given user navigates to create new password page
    When user clicks on the "back to welcome screen link"
    Then More "home page" should load successfully


  @ForgotPassword
  #USAT-8578
  Scenario: Error messages for create password field
    Given user navigates to create new password page
    When user updates the password field for "dsbvghghsvdb" in "password input field"
    Then a "password error criteria" message will be displaying for the wrong password or blank fields

  @ForgotPassword
  #USAT-8580
  Scenario: Error messages for confirm password field
    Given user navigates to create new password page
    When user enters "gfhgfghgh" in the "confirm password input field"
    Then a "password do not match error" message will be displaying for the wrong password or blank fields
    And the "update password button" will not be in enabled mode


  @ForgotPassword
  #USAT-8578, USAT-8579
  Scenario: Password criteria
    Given user navigates to create new password page
    When user enters valid "Pass123@" in "password input field"
    Then user sees "password meets criteria" on the screen

  @ForgotPassword
  Scenario Outline: Password and Confirm Password are a match
    Given user navigates to create new password page
    When user enters "<password>" and "<confirm password>" in password and confirm password fields
    Then user compares if "password input field" and "confirm password input field" has the same value

    Examples:
      | password | confirm password |
      | Pass@123 | Pass@123         |
     # | Pass@234 | Pass@234         |


  @ForgotPassword
  #USAT-8577, USAT-8585
  Scenario: Update password button inactive status
    Given user navigates to create new password page
    When user enters "Pass@234" and " " in password and confirm password fields
    Then user sees the update button indisabled mode and password meets criteria on the screen

  @ForgotPassword
  Scenario: Update password button active status
    Given user navigates to create new password page
    When user enters "Pass@123" and "Pass@123" in password and confirm password fields
    Then user compares if "password input field" and "confirm password input field" has the same value
    And the "update password button" will be in enabled mode
    And the "password meets criteria" will be in enabled mode

  @ForgotPassword
#  @SmokeTest
  #USAT-8584
  Scenario: Login with updated password
    Given user launches the application and to navigate to sign in page
    Then user enters a valid email and updated password in respective field
    And More "dashboard page" should load successfully





