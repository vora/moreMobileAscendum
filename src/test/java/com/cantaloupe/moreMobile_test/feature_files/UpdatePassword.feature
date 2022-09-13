Feature: Update Password
  As a more app user, I want to update my password so that I am able to login with the new password
  #USAT-7983, USAT-5950

  Rule:
  - Password must be between 8 and 20 characters.
  - should contain uppercase letter, lowercase letter,
  - should contain number, and a special character from this list: $@.!"%*#?&'()+,-/\;:<>={}|~[]^te scenarios

  Background:
  Given user launches the application and to navigate to change password page by entering valid email and password

     #USAT-8610

 @UpdatePassword
   # @UpdatePassword
    Scenario: Update password functionality
     # Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters valid old, new and confirm passwords in respective fields
      And user clicks on update button and a success alert pop up displays on the screen

    @UpdatePassword
    #USAT-8610
   # @UpdatePassword
      Scenario: Athentication failure
      #Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters invalid old, new and confirm passwords in respective fields
      And User clicks on update button and a athentication failure alert pop up displays on the screen

    @UpdatePassword
    #@UpdatePassword
  #USAT-8596
    Scenario: Navigation to password change screen
      #Given user launches the application and to navigate to change password page by entering valid email and password
      And user verifies if the password field has masked value
      Then More "change password page" should load successfully

    @UpdatePassword
  #USAT-8597, USAT-8598,
    #@UpdatePassword
    Scenario: Mask and unmask old password field
     # Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters "Mason@123" in the "old password input field"
      And user sees that the "old password input field" is masked
      Then user clicks on the "show password link"
      And user sees that the "old password input field" is not masked
      Then user clicks on the "hide password link"
      And user sees that the "old password input field" is masked

    @UpdatePassword
  #USAT-8600,  USAT-8601,
    #@UpdatePassword
    Scenario: Mask and unmask password field
     # Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters "Pass@123" in the "password input field"
      And user sees that the "password input field" is masked
      Then user clicks on the "new password show link"
      And user sees that the "password input field" is not masked
      Then user clicks on the "new password hide link"
      And user sees that the "password input field" is masked

    @UpdatePassword
  #USAT-8602, USAT-8604,
    #@UpdatePassword
    Scenario: mask and unmask confirm password field
      #Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters "Pass@123" in the "confirm password input field"
      And user sees that the "confirm password input field" is masked
      Then user clicks on the "confirm password show link"
      And user sees that the "confirm password input field" is not masked
      Then user clicks on the "confirm password hide link"
      And user sees that the "confirm password input field" is masked

    @UpdatePassword
  #USAT-8605, USAT-8607, USAT-8609
    #@UpdatePassword
    Scenario:  Error messages for new password field
      #Given user launches the application and to navigate to change password page by entering valid email and password
      When the "password input field" will be in enabled mode
      Then user updates the password field for "dsbvghghsvdb" in "password input field"
      #And a "password error criteria" message will be displaying for the wrong password or blank fields
      And a "password error criteria" should be displaying for the password or wrong fields

    @UpdatePassword
    #USAT-8605, USAT-8607, USAT-8609
   # @UpdatePassword
    Scenario:  Error messages for confirm password field
      #Given user launches the application and to navigate to change password page by entering valid email and password
      When user updates the password field for "dsbvghghsvdb" in "password input field"
      Then user enters "gfhgfghgh" in the "confirm password input field"
      And a "password do not match error" should be displaying for the password or wrong fields
      #And The "update password button" will not be in enabled mode

    @UpdatePassword
#    @SmokeTest
  #USAT-8608
    #@UpdatePassword
    Scenario: Password meets criteria
      #Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters "Pass@123" in the "password input field"
      Then user sees "password meets criteria" on the screen
    @UpdatePassword
    Scenario: Verify if the password and confirm password fields values are a match
      #Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters "Mason@123" in the "password input field"
      Then user enters "Mason@123" in the "confirm password input field"
      And user compares if "password input field" and "confirm password input field" has the same value

    @UpdatePassword
   # @UpdatePassword
  #USAT-8604
    Scenario: Update password button disabled funcionality
     # Given user launches the application and to navigate to change password page by entering valid email and password
      When user enters valid password and confirm in password and confirm password fields
      Then user enters invalid "" in "old password input field"
      And the user sees that the "update password button" is in disabled mode

    @UpdatePassword
    #@UpdatePassword
    Scenario Outline: Verify that no fields are left blank for update password to be in active status
      When user enters valid "<password>" in "old password input field"
      And user enters valid "<new password>" in "password input field"
      And user enters valid "<confirm password>" in "confirm password input field"
      Then user compares if "password input field" and "confirm password input field" has the same value
      And user verifies if there are any fields left blank for update password button to be active

      Examples:
        | password  | confirm password | new password |
        | Mason@123 | Pass@123         | Pass@123     |


