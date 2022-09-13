Feature: Update Profile
  As a more app user, I want to change my account details so that I can keep my account details up-to-date.
#USAT-5589

  @UpdateProfile
#  @SmokeTest
    #USAT-5589
  Scenario: Account details are updated successfully
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user fills out the Update Profile form as below:
      | First Name      | genericFirstName     |
      | Last Name       | genericLastName      |
      | Mobile Number   | genericMobileNo      |
      | Street address  | genericStreetAddress |
      | City            | genericCity          |
      | State           | genaricState         |
      | Zip/Postal code | genericZipcode       |
    And user check if there are any error displayed on the screen
    Then user confirms the update has been a success by clicking on update button

  @UpdateProfile
    #USAT-8458
  Scenario: Update Profile screen navigation
    Given user launches the application and navigates to dashboard screen by entering valid email and password
    When user clicks on the "profile link"
    Then More "update profile page" should load successfully


    #USAT-8460
  @UpdateProfile
  Scenario: Non editable email field
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user sees "email input field" on the screen
    Then user verifies the email value present against the registered value
    And user verifies if the email field is in non editable mode


    #USAT-8462, USAT-8461
  @UpdateProfile
  Scenario: Navigate to change password page
    Given user launches the application and navigates to dashboard screen by entering valid email and password
    When user clicks on the "profile link"
    Then More "update profile page" should load successfully
    And user verifies if the password field has masked value
    Then user clicks on the "password change link"
    And More "change password page" should load successfully

  @UpdateProfile
    #USAT-8467,
  Scenario: Error displayed for blank fields
    Given user launches the application and navigates to dashboard screen by entering valid email and password
    When user clicks on the "profile link"
    Then More "update profile page" should load successfully
    And user verifies if the error message is displayed for blank fields on the page:
      | first name error     | firstNameBlankError     |
      | last name error      | lastNameBlankError      |
      | mobile number error  | mobileNoBlankError      |
      | street address error | streetAddressBlankError |
      | city error           | cityBlankError          |
      | state error          | stateBlankError         |
      | zipcode error        | zipcodeBlankError       |


  @UpdateProfile
  Scenario Outline: Already registered phone number functionality
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user updates the mobile field for "<existing phone number>" in "mobile number input field"
    Then user will see "phone number in use error" on the screen
    And user sees the "This phone number is already in use. Please use a different phone number or contact customer service at +1-888-561-4748." for "phone number in use error"

    Examples:
      | existing phone number |
      | 1234567890            |

  @UpdateProfile
  Scenario Outline: Service number in the error is clickable
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user updates the mobile field for "<existing phone number>" in "mobile number input field"
    Then user will see "phone number in use error" on the screen
    And the service number displayed in the error is clickable

    Examples:
      | existing phone number |
      | 1234567890            |


  @UpdateProfile
    #USAT-8471
  Scenario: Mobile number format
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user sees "email input field" on the screen
    Then More "update profile page" should load successfully
    And user verifies the format for "mobile number input field"


    #USAT-8474
  @UpdateProfile
  Scenario: Verify the uniqueness of the mobile number entered
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user updates the mobile field with a unique number
    Then user enters a mobile number and verifies that has no phone number in use error displayed


        #USAT-8474
  @UpdateProfile
  Scenario: Tick mark represents the uniqueness of mobile
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user updates the mobile field with a unique number
    Then user see's the tick mark for mobile field

  @UpdateProfile
  Scenario: Null Value check for update profile
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user fills out the Update Profile form as below:
      | First Name      | genericFirstName     |
      | Last Name       | genericLastName      |
      | Mobile Number   | genericMobileNo      |
      | Street address  | genericStreetAddress |
      | City            | genericCity          |
      | State           | genaricState         |
      | Zip/Postal code | genericZipcode       |
    Then user check if there are any error displayed on the screen
    And user see's if there are any null values on the page
      | First Name      | blankFirstName     |
      | Last Name       | blankLastName      |
      | Mobile Number   | blankMobileNumber  |
      | Street address  | blankStreetAddress |
      | City            | blankCity          |
      | State           | blankState         |
      | Zip/Postal code | blankZipcode       |

  @UpdateProfile
   #USAT-8467, USAT-8470, USAT-8475, USAT-8480
  Scenario: Verify that the there are no errors displayed on the screen
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user fills out the Update Profile form as below:
      | First Name      | genericFirstName     |
      | Last Name       | genericLastName      |
      | Mobile Number   | genericMobileNo      |
      | Street address  | genericStreetAddress |
      | City            | genericCity          |
      | State           | genaricState         |
      | Zip/Postal code | genericZipcode       |
    And user check if there are any error displayed on the screen

  @UpdateProfile
#USAT-8459
  Scenario: Verify that clicking out will Sign out will log out the user from the application
    Given user launches the application and to navigate to update profile page by entering valid email and password
    When user clicks on the "sign out link"
    Then More "home page" should load successfully


  Rule: State would only be accepting valid State codes (example: MO, OH, CA etc)
  Rule: State would not be accepting the whole name (Ex: Ohio, California are not valid)
    @UpdateProfile
    Scenario: Invalid state entry
      Given user launches the application and to navigate to update profile page by entering valid email and password
      When user fills out the Update Profile form as below:
        | First Name      | genericFirstName     |
        | Last Name       | genericLastName      |
        | Mobile Number   | genericMobileNo      |
        | Street address  | genericStreetAddress |
        | City            | genericCity          |
        | Zip/Postal code | genericZipcode       |
      And user enters "yghy" in the "state input field"
      Then user clicks on the "update button"
      And user sees "invalid state error alert pop up" on the screen


  Rule: Zipcode only accepts a value of 5 digits or an optional of - along with 4 digits (Examples of valid zipcodes format are xxxxx, xxxxx-xxxx)

    @UpdateProfile
    Scenario: Invalid zipcode entry
      Given user launches the application and to navigate to update profile page by entering valid email and password
      When user fills out the Update Profile form as below:
        | First Name     | genericFirstName     |
        | Last Name      | genericLastName      |
        | Mobile Number  | genericMobileNo      |
        | Street address | genericStreetAddress |
        | City           | genericCity          |
        | State          | genaricState         |
      And user enters "234435567" in the "zip/postal code input field"
      Then user clicks on the "update button"
      And user sees "invalid zipcode error alert pop up" on the screen


