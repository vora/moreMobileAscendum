Feature: Manual reload
  As a more app user, I want to manually reload my more app card

 # @USAT-7990, @USAT-5874

    @PrepaidCardManualReload
  Scenario: Manual reload success flow
    #Given user launches the application and to navigate to "prepaid card manual reload page" by entering valid email and password
    #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
   # When user clicks on the "reload dropdown"
    Then user checks for click to pay toggle button and turns it off
    Then user will be able to select the following value - "$10" from "reload dropdown"
    Then user fills out the remaining feilds on the page and clicks on "reload card button"

  @PrepaidCardManualReload
  Scenario: Default dropdown value
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    When user clicks on the "reload dropdown"
    Then user checks for click to pay toggle button and turns it off
   # Then user sees that the "$25" will the default value selected in "reload dropdown"
    Then user sees that the "reload dropdown" has a default value of "$25"

  @PrepaidCardManualReload
  #@USAT-8415
  Scenario: Available options in the reload dropdown
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user clicks on the "reload dropdown"
    Then user checks for click to pay toggle button and turns it off
    And user will be able to see the available options for the "reload dropdown" with the displayed value as "25"

  @PrepaidCardManualReload
  #@USAT-8416
  Scenario: Select any value from dropdown
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user clicks on the "reload dropdown"
    Then user checks for click to pay toggle button and turns it off
    And user will be able to select the following value - "$100" from "reload dropdown"

  @PrepaidCardManualReload
 # @USAT-8426
  Scenario: Default month dropdown value
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user clicks on the "reload dropdown"
    Then user checks for click to pay toggle button and turns it off
    When user sees "address check box" on the screen
    And user clicks on the "month dropdown"

    Then user sees that the month - "month dropdown" will have the following value - "January"
    When user clicks on the "year dropdown"
    Then user sees that the year - "year dropdown" will have the following value - "2033"

  @PrepaidCardManualReload
  #@USAT-8427
  Scenario: Month dropdown error
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user clicks on the "month dropdown"
    When user clicks on the "year dropdown"
    Then user checks for click to pay toggle button and turns it off
    And user fills out the remaining feilds on the manual reload page apart from expiration month and year
    Then user will be seeing "month year blank error" on the screen

  @PrepaidCardManualReload
  #@USAT-8392
  Scenario: Add new address
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    # Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    And user clicks on the "address check box"
    Then user will be seeing "city input field" on the screen

  @PrepaidCardManualReload
  #@USAT-8393
  Scenario: unchecking the box removes newly address fields
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    When user clicks on the "address check box"
    Then user will be seeing "city input field" on the screen

    And user clicks on the "address check box"
    Then new address fields will be removed from the screen

  @PrepaidCardManualReload
 # @USAT-8394
  Scenario: Data enetered will be saved
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    When user clicks on the "address check box"
    Then user will be seeing "city input field" on the screen
    And user enters "new city" in the "city input field"
    And user unchecks and checks the checkbox again
    Then user will be seeing "new city" on the entered value in the "city input field"

  @PrepaidCardManualReload
  #@USAT-8395
  Scenario: Unchecking the address check box displays previous data
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    When user checks the address checkbox and enters new data
    And user clicks on the "address check box"
    Then user sees that the value is present in the address field of manual flow and compares it against the registered value

  @PrepaidCardManualReload
  #@USAT-8397, @USAT-8399, @USAT-8401, @USAT-8403
  Scenario: Blank error messages for all fields
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    When user clicks on the "address check box"
    Then user sees blank errors are displayed if fields are left blank:
      | blank street address error | streetAddressBlankError |
      | blank city error           | cityBlankError          |
      | blank state error          | stateBlankError         |
      | blank zipcode error        | zipcodeBlankError       |

  @PrepaidCardManualReload
  Scenario: Enabled fields data entry
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    When user clicks on the "address check box"
    Then user sees blank errors are displayed for address section if fields are left blank:
      | blank street address error | streetAddressBlankError |
      | blank city error           | cityBlankError          |
      | blank state error          | stateBlankError         |
      | blank zipcode error        | zipcodeBlankError       |

  @PrepaidCardManualReload
  #@USAT-8431
  Scenario: Mask and unmask cvv input field
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
    #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
    When user clicks on the "address check box"
    And user enters "1234" in the "cvv input field"
    And user sees that the "cvv input field" is masked
    Then user clicks on the "cvv show link"
    And user sees that the "cvv input field" is not masked
    Then user clicks on the "cvv hide link"
    And user sees that the "cvv input field" is masked

  @PrepaidCardManualReload
 # @USAT-8432
  Scenario: Non editable address field
    Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
     #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
    When user will be seeing "reload dropdown" on the screen
    Then user checks for click to pay toggle button and turns it off
#    When user clicks on the "address check box"
    When user sees "address input field" on the screen
    Then user verifies if the address field is in non editable mode
    And user sees that the value is present in the address field of manual flow and compares it against the registered value

  Rule:
  - Only 16 or 15 digits are accepted as a card number
  - If the number is less than 19 digits, error will be thrown`
  - The input field will not accept any entry after entering 19 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed


     # Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password

    @PrepaidCardManualReload
    Scenario Outline: Invalid credit card number Alert pop up when less digits are entered
      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
      When user will be seeing "reload dropdown" on the screen
      Then user checks for click to pay toggle button and turns it off
      When  user sees "address check box" on the screen
      And user enters "<invalid card number>" in the "credit card number input field"
      And user fills out the remaining feilds on the manual reload page apart from credit card
      Then user will be seeing "invalid card number alert pop up" on the screen

      Examples:
        | invalid card number |
        | 6                   |
#        | 65                  |
#        | 6739845             |
#        | 1234567890123456789 |
#        | 123432123432123456  |

    @PrepaidCardManualReload
#   # @USAT-8421
#    Scenario Outline: only numbers are allowed from aplhanumeric characters
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
#      When  user clicks on the "address check box"
#      And user enters "<invalid card number>" in the "credit card number input field"
#      Then user sees that only numbers are entered even though he enters alphanumeric characters for "credit card number input field"
#      Examples:
#        | invalid card number |
#        | dfdsf76565878       |
##        | 2132#@%Tasfdv       |

#    @PrepaidCardManualReload
#    Scenario Outline: no alphabets or special characters are allowed
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
#      When  user clicks on the "address check box"
#      And user will be seeing "credit card number input field" on the screen
#      Then user sees that no value is entered after entering alphabets or special characters - "<invalid card number>" in "credit card number input field"
#      Examples:
#        | invalid card number |
#        | sdfghkjvbl          |
##        | @#$%&*%$^           |
##        | DFGHKJ$%^&          |

#    @PrepaidCardManualReload
#   # @USAT-8422
#    Scenario: error for blank more card input field
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
#      When  user clicks on the "address check box"
#      And user enters "     " in the "credit card number input field"
#      And user clicks on the "credit card number input field"
#      And user clicks on the "cvv input field"
#      Then user will be seeing "credit card blank error" on the screen
#

  Rule:
  - Only 3 or 4 digits are accepted as a cvv number
  - If the number is less than 3 digits, error will be thrown`
  - The input field will not accept any entry after entering 4 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed


     # Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password

    @PrepaidCardManualReload
  #  @USAT-8340
    Scenario Outline: Invalid cvv number error when 1 or 2 digits are entered or for blank entry
      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
      When user will be seeing "reload dropdown" on the screen
      Then user checks for click to pay toggle button and turns it off
      When  user clicks on the "address check box"
      And user enters "<invalid cvv number>" in the "cvv input field"
      And user does a random click on the screen
      Then user will be seeing "cvv blank error" on the screen

      Examples:
        | invalid cvv number |
        | 6                  |
#        | 65                 |
#        |                    |

    @PrepaidCardManualReload
    #@USAT-8428
#    Scenario Outline: only numbers are allowed from aplhanumeric characters
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
#      When  user clicks on the "address check box"
#      And user enters "<invalid cvv number>" in the "cvv input field"
#      Then user sees that only numbers are entered even though he enters alphanumeric characters for "cvv input field"
#      Examples:
#        | invalid cvv number |
#        | dfdsf76565878      |
##        | 2132#@%Tasfdv      |

    @PrepaidCardManualReload
#    Scenario Outline: no alphabets or special characters are allowed
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
#      When  user clicks on the "address check box"
#      And user will be seeing "cvv input field" on the screen
#      Then user sees that no value is entered after entering alphabets or special characters - "<invalid cvv number>" in "cvv input field"
#      Examples:
#        | invalid cvv number |
#        | sdfghkjvbl         |
##        | @#$%&*%$^          |
##        | DFGHKJ$%^&         |


  Rule: Zipcode only accepts a value of 5 digits or an optional of - along with 4 digits
  (Examples of valid zipcodes format are xxxxx, xxxxx-xxxx)

#    @PrepaidCardManualReload
#    Scenario: Invalid zipcode entry
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#       #Given user launches the application and to navigate to prepaid card manual reload page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
##      When user clicks on the "address check box"
#      When user fills out the address form as below:
#        | Street address | genericStreetAddress |
#        | State          | genericState         |
#        | City           | genericCity          |
#      And user enters "yghy" in the "zip/postal code input field"
#      Then user will be able to select reload balance, enter credit card and cvv
#      Then user clicks on the "reload card button"
#      And user sees "invalid zipcode error alert pop up" on the screen


  Rule:
  - State would only be accepting valid State codes (example: MO, OH, CA etc)
  - State would not be accepting the whole name (Ex: Ohio, California are not valid)
  - No aplhanumberics, special characters are allowed


#    @PrepaidCardManualReload
#    Scenario: Invalid state entry
#    #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
#      Given user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password
#      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
#      When user fills out the address form as below:
#        | Street address  | genericStreetAddress |
#        | City            | genericCity          |
#        | zip/postal code | genericZipcode       |
#      And user enters "yghy" in the "state input field"
#      Then user will be able to select reload balance, enter credit card and cvv
#      And user clicks on the "reload card button"
#      Then user sees "invalid state error alert pop up" for state on the screen

    @PrepaidCardManualReload
    Scenario: Auto reload success flow
      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      When user will be seeing "reload dropdown" on the screen
#      Then user checks for click to pay toggle button and turns it off
      When user clicks on the "reload dropdown"
      Then user will be able to select the following value - "$10" from "reload dropdown"
      And user will be able to select the following value - "$100" from "balance dropdown"
      Then user fills out the remaining feilds on the page and clicks on "schedule reload button"

    @PrepaidCardManualReload
    Scenario: Overiding Auto Reload through Manual flow
      Given user launches the application and to navigate to prepaid card details page by entering valid email and password
      When user clicks on the "manual reload label"
      Then user looks for the status of reload and cancels it through manual flow
      And More "prepaid card manual reload page" should load successfully

    @PrepaidCardManualReload
    Scenario: Toggle off auto reload
      Given user launches the application and to navigate to prepaid card details page by entering valid email and password
      When user will be seeing "auto reload label" on the screen
      Then user looks for the status of reload and toggles it off if it is active

