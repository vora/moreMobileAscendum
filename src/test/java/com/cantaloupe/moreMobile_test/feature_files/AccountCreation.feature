Feature: Account Creation
  As a more app user, I want to create an account using email ID to login to the application
#USAT-6087, USAT-8313

  #@SmokeTest
  #@USAT-8719
  @AccountCreation
  Scenario: Successful Registration flow
    Given user launches the application and navigates to create account page by entering valid email
    When user fills out the create account form as below:
      | Password         | createPassword       |
      | Confirm Password | confirmPassword      |
      | Firstname        | genericFirstName     |
      | Lastname         | genericLastName      |
      | Mobile number    | genericMobileNo      |
      | Street address   | genericStreetAddress |
      | City             | genericCity          |
      | State            | genericState         |
      | Zip/Postal code  | genericZipcode       |
    And user clicks on the "complete button"
    Then More "confirm registration page" should load successfully
    And user should see "good news text" and "thanks for registering with more text" on the screen

# @AccountCreation
#  Scenario: Presence of placeholders in every field
#    Given user launches the application and navigates to initial create account page
#    When user enters a valid email and clicks on next button
#    And user see's the placeholders for all the fields on the screen


  #@USAT-8668
  @AccountCreation
  Scenario: Login button displays for an existing user
    Given user launches the application and navigates to initial create account page
    Then user enters the existing email in the email input field
    And user sees "email already in use text" on the screen

  Scenario: Navigate to Sign in page with existing account
    Given user logs into the account with existing email
    When user sees "sign in header" on the screen
    Then More "signin existingaccount page" should load successfully
    And the user sees that the "sign in button" is in disabled mode

  #@USAT-8682
  @AccountCreation
  Scenario: Password criteria is met
    Given user launches the application and navigates to create account page by entering valid email
    When user enters valid password in password input field
    Then user sees "password meets criteria" on the screen

  #@USAT-8681
  @AccountCreation
  Scenario: Error messages displays for wrong password
    Given user launches the application and navigates to create account page by entering valid email
    When user enters "gg" in the "password input field"
    Then a "password error criteria" should be displaying for the password or wrong fields

  #@USAT-8685
  @AccountCreation
  Scenario: Error messages displays for confirm password
    Given user launches the application and navigates to create account page by entering valid email
    When user enters "<confirm password>" in the "confirm password input field"
    Then a "password do not match error" should be displaying for the password or wrong fields

  #@USAT-8680
  @AccountCreation
  Scenario: Mask and unmask password field
    Given user launches the application and navigates to create account page by entering valid email
    When user enters "Pass@123" in the "password input field"
    And user clicks on the "password show link"
    Then user sees that the "password input field" is not masked
    And user clicks on the "password hide link"
    Then user sees that the "password input field" is masked


  #@USAT-8680, @USAT-8678
  @AccountCreation
  Scenario: Mask and unmask confirm password field
    Given user launches the application and navigates to create account page by entering valid email
    When user enters "Pass@123" in the "confirm password input field"
    And user clicks on the "confirm password show link"
    Then user sees that the "confirm password input field" is not masked
    And user clicks on the "confirm password hide link"
    Then user sees that the "confirm password input field" is masked

  @AccountCreation
  Scenario: Password and confirm password meets the criteria
    Given user launches the application and navigates to create account page by entering valid email
    When user enters valid password and confirm in password and confirm password fields
    Then user compares if "password input field" and "confirm password input field" has the same value

   # @SmokeTest
 # @USAT-8665, @USAT-8666
  @AccountCreation
  Scenario Outline: Invalid email error
    Given user launches the application and navigates to create account options page
    When user sees "create account header" on the screen
    And user clicks on the "next button"
    Then user sees if blank email error is displayed on entering a wrong "<emailID>"

    Examples:
      | emailID                  |
      | 123$$#@#234324325@yahoo. |
#      |                          |



 # @USAT-8693, @USAT-8717
  @AccountCreation
  Scenario: Blank error messages for all fields
    Given user launches the application and navigates to create account page by entering valid email
    When user enters "Password" in the "password input field"
    Then user sees blank errors are displayed if fields are left blank:
      | blank firstname error      | firstNameBlankError     |
      | blank lastname error       | lastNameBlankError      |
      | invalid phone number error | mobileNoBlankError      |
      | blank street address error | streetAddressBlankError |
      | blank city error           | cityBlankError          |
      | blank state error          | stateBlankError         |
      | blank zipcode error        | zipcodeBlankError       |

  @AccountCreation
  Scenario: Already registered phone number functionality
    Given user launches the application and navigates to create account page by entering valid email
    When user enters existing mobile number in the "mobile number input field"
    Then user will be seeing "phone number in use error" on the screen
    And user sees the "This phone number is already in use. Please use a different phone number or contact customer service at +1-888-561-4748." for "phone number in use error"

  @AccountCreation
  Scenario: Unique mobile number registration
    Given user launches the application and navigates to create account page by entering valid email
    When user enters valid number in mobile number input field
    Then user enters a mobile number and verifies that has no phone number in use error displayed

   # @USAT-8697
  @AccountCreation
    Scenario: Service number in the error is clickable
    Given user launches the application and navigates to create account page by entering valid email
    When user enters existing mobile number in the "mobile number input field"
    Then user will be seeing "phone number in use error" on the screen
    And the service number displayed in the error is clickable

  #@USAT-8692
  @AccountCreation
  Scenario: Mobile number format
    Given user launches the application and navigates to create account page by entering valid email
    When user enters "2435654676" in the "mobile number input field"
    And user verifies the format for "mobile number input field"

  #@USAT-8690
  @AccountCreation
  Scenario: PhoneNumber in Possession and reseeting label validation
    Given user launches the application and navigates to create account page by entering valid email
    When user sees "personal details header" on the screen
    And user should see "phone number in possession label" and "try resetting phone number label" on the screen


  Rule:
   - State would only be accepting valid State codes (example: MO, OH, CA etc)
   - State would not be accepting the whole name (Ex: Ohio, California are not valid)
   - No aplhanumberics, special characters are allowed

    #@USAT-8717
   @AccountCreation
    Scenario: Invalid state entry
      Given user launches the application and navigates to create account page by entering valid email
      When user fills out the create account form as below:
        | Password         | createPassword       |
        | Confirm Password | confirmPassword      |
        | Firstname        | genericFirstName     |
        | Lastname         | genericLastName      |
        | Mobile number    | genericMobileNo      |
        | Street address   | genericStreetAddress |
        | City             | genericCity          |
        | Zip/Postal code  | genericZipcode       |
      And user enters "yghy" in the "state input field"
      Then user clicks on the "complete button"
      And user sees "invalid state error alert pop up" on the screen


  Rule: Zipcode only accepts a value of 5 digits or an optional of - along with 4 digits
  (Examples of valid zipcodes format are xxxxx, xxxxx-xxxx)

      #@USAT-8718
    @AccountCreation
    Scenario: Invalid zipcode entry
      Given user launches the application and navigates to create account page by entering valid email
      When user fills out the create account form as below:
        | Password         | createPassword       |
        | Confirm Password | confirmPassword      |
        | Firstname        | genericFirstName     |
        | Lastname         | genericLastName      |
        | Mobile number    | genericMobileNo      |
        | Street address   | genericStreetAddress |
        | State            | genericState         |
        | City             | genericCity          |
      And user enters "yghy" in the "zip/postal code input field"
      Then user clicks on the "complete button"
      And user sees "invalid zipcode error alert pop up" on the screen

    #@USAT-8709
    @AccountCreation
    Scenario: Navigation to terms of screen
      Given user launches the application and navigates to create account page by entering valid email
      When user scrolls down to the "terms of use link" on the screen and clicks it
      Then user sees "more terms use text" on the screen
      And user scrolls down to the "back to sign up button" on the screen and clicks it
      And More "create account page" should load successfully

    #@USAT-8711
    @AccountCreation
    Scenario: Navigation to Privacy policy use screen
      Given user launches the application and navigates to create account page by entering valid email
      When user scrolls down to the "privacy policy link" on the screen and clicks it
      Then user sees "privacy policy text" on the screen
      And user scrolls down to the "back to sign up button" on the screen and clicks it
      And More "create account page" should load successfully

   #@USAT-8671
    @AccountCreation
    Scenario: Email input field has prefilled value
      Given user launches the application and navigates to initial create account page
      When user enters "cntp9909p1@yopmail.com" in the "email input field"
      And user clicks on the "next button"
      Then user sees the "cntp9909p1@yopmail.com" is already prefilled in the "email input field" field on the page

    #@USAT-8672
    @AccountCreation
    Scenario: Email field is editable
      Given user launches the application and navigates to initial create account page
      When user enters "cntp99tickp1@yopmail.com" in the "email input field"
      And user clicks on the "next button"
      Then user sees the "cntp99tickp1@yopmail.com" is already prefilled in the "email input field" field on the page
      And user is able to edit the "email input field" with "test1@yopmail.com"

    #@USAT-8667
    @AccountCreation
    Scenario: Unique email registration flow
      Given user launches the application and navigates to initial create account page
      When user enters a unique email in the email input field
      Then look if the account is already registered and skip registration by clicking on login button before cliking on "next button"

    #@USAT-8668
    @AccountCreation
    Scenario: Unsuccessful existing email registration flow
      Given user launches the application and navigates to initial create account page
      When user enters the existing email in the email input field
      Then user will be seeing "login button" on the screen
      And user will see "email already in use text" on the screen

   #@USAT-8676
    @AccountCreation
    Scenario: Disabled sign button for existing user flow
      Given user launches the application and to navigate to different options page by logging in with already registered email
      #When user clicks on the "continue with email link"
      When user sees "sign in header" on the screen
      Then More "signin existingaccount page" should load successfully
      And the fields are blank and the sign in button is in disabled mode


    @AccountCreation
    Scenario: Verify that the user is able to navigate back to home page from create account page
     Given user launches the application and navigates to initial create account page
      #Given user launches the application and navigates to create account page by entering valid email
      When user sees "next button" on the screen
      Then user sees if he is navigated back to home page


