Feature: Auto reload
  As a more app user, I want to ato reload my more app card so that I do not run out of balance

@PrepaidCardAutoReload
 # @USAT-8413, @USAT-8414
  Scenario: Default dropdown value for reload balance
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "reload dropdown"
    Then user sees that the "$25" will the default value selected in "reload dropdown"

  @PrepaidCardAutoReload
 # @USAT-8411, @USAT-8412
  Scenario: Inactive status for first time user
    Given user launches the application and to navigate to prepaid card details page by entering valid email and password
    When user sees "auto reload label" on the screen
    Then the following "auto reload label" and "inactive label" will display on the screen

  @PrepaidCardAutoReload
#  @USAT-8417
  Scenario: Default dropdown value for balance
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "balance dropdown"
    Then user sees that the "$10" will the default value selected in "balance dropdown"

  @PrepaidCardAutoReload
#  @USAT-8415
  Scenario: Available options in the reload dropdown
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "reload dropdown"
    And user will be able to see the available options for the "reload dropdown" with the displayed value as "25"

  @PrepaidCardAutoReload
 # @USAT-8418
  Scenario: Available options in the balance dropdown
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "balance dropdown"
    And user will be able to see the available options for the "balance dropdown" with the displayed value as "10"

  @PrepaidCardAutoReload
 # @USAT-8416
  Scenario: Select any value from reload dropdown
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "reload dropdown"
    And user will be able to select the following value - "$100" from "reload dropdown"

  @PrepaidCardAutoReload
 # @USAT-8419
  Scenario: Select any value from balance dropdown
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "balance dropdown"
    And user will be able to select the following value - "$100" from "balance dropdown"

  @PrepaidCardAutoReload
 # @USAT-8426
  Scenario: Default month dropdown value in realod dropdown
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "month dropdown"
    Then user sees that the following value - "January" will be displayed in the "month dropdown"
    When user clicks on the "year dropdown"
    Then user sees that the following value - "2022" will be displayed in the "year dropdown"

  @PrepaidCardAutoReload
 # @USAT-8427
  Scenario: Default month dropdown value in balance dropdown
    Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
    When user sees "set up auto reload header" or "auto reload header" on the screen
    And the toggle button is off
    When user clicks on the "month dropdown"
    And user clicks on the "year dropdown"
    And user fills out the remaining feilds on the auto reload page apart from expiration month and year
    Then user will be seeing "month year blank error" on the screen


  Rule:
  - Only 16 or 15 digits are accepted as a card number
  - If the number is less than 19 digits, error will be thrown`
  - The input field will not accept any entry after entering 19 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed

    Background:
      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      When user sees "set up auto reload header" or "auto reload header" on the screen

    @PrepaidCardAutoReload
    Scenario Outline: Invalid credit card number Alert pop up when less digits are entered
      And the toggle button is off
      And user enters "<invalid card number>" in the "credit card number input field"
      When user fills out the remaining feilds on the auto reload page apart from credit card
      Then user will be seeing "invalid card number alert pop up" on the screen

      Examples:
        | invalid card number |
        | 6                   |
#        | 65                  |
#        | 6739845             |
#        | 1234567890123456789 |
#        | 123432123432123456  |

#    @PrepaidCardAutoReload
#    #@USAT-8421
#    Scenario Outline: only numbers are allowed from aplhanumeric characters
#      And the toggle button is off
#      And user enters "<invalid card number>" in the "credit card number input field"
#      Then user sees that only numbers are entered even though he enters alphanumeric characters for "credit card number input field"
#      Examples:
#        | invalid card number |
#        | dfdsf76565878       |
##        | 2132#@%Tasfdv       |

#    @PrepaidCardAutoReload
#    Scenario Outline: no alphabets or special characters are allowed
#      And the toggle button is off
#      And user will be seeing "credit card number input field" on the screen
#      Then user sees that no value is entered after entering alphabets or special characters - "<invalid card number>" in "credit card number input field"
#      Examples:
#        | invalid card number |
#        | sdfghkjvbl          |
##        | @#$%&*%$^           |
##        | DFGHKJ$%^&          |

#    @PrepaidCardAutoReload
#  #  @USAT-8422
#    Scenario: error for blank more card input field
#      And the toggle button is off
#      When user enters "     " in the "credit card number input field"
#      And user clicks on the "credit card number input field"
#      And user clicks on the "cvv input field"
#      Then user will be seeing "credit card blank error" on the screen


  Rule:
  - Only 3 or 4 digits are accepted as a card number
  - If the number is less than 3 digits, error will be thrown`
  - The input field will not accept any entry after entering 4 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed

    Background:
      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      When user sees "set up auto reload header" or "auto reload header" on the screen

    @PrepaidCardAutoReload
   # @USAT-8340
    Scenario Outline: Invalid cvv number error when 1 or 2 digits are entered or for blank entry
      And the toggle button is off
      And user enters "<invalid cvv number>" in the "cvv input field"
      When user does a random click on the screen
      Then user will be seeing "cvv blank error" on the screen

      Examples:
        | invalid cvv number |
        | 6                  |
#        | 65                 |
#        |                    |

#    @PrepaidCardAutoReload
#   # @USAT-8428
#    Scenario Outline: only numbers are allowed from aplhanumeric characters
#      And the toggle button is off
#      And user enters "<invalid cvv number>" in the "cvv input field"
#      Then user sees that only numbers are entered even though he enters alphanumeric characters for "cvv input field"
#      Examples:
#        | invalid cvv number |
#        | dfdsf76565878      |
##        | 2132#@%Tasfdv      |

#    @PrepaidCardAutoReload
#    Scenario Outline: no alphabets or special characters are allowed
#      And the toggle button is off
#      And user will be seeing "cvv input field" on the screen
#      Then user sees that no value is entered after entering alphabets or special characters - "<invalid cvv number>" in "cvv input field"
#      Examples:
#        | invalid cvv number |
#        | sdfghkjvbl         |
##        | @#$%&*%$^          |
##        | DFGHKJ$%^&         |

    @PrepaidCardAutoReload
  #  @USAT-8431
    Scenario: Mask and unmask cvv input field
      When user enters "1234" in the "cvv input field"
      And the toggle button is off
      And user sees that the "cvv input field" is masked
      Then user clicks on the "cvv show link"
      And user sees that the "cvv input field" is not masked
      Then user clicks on the "cvv hide link"
      And user sees that the "cvv input field" is masked

    @PrepaidCardAutoReload
   # @USAT-8392
    Scenario: Add new address
      #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
#      And user will be seeing "reload dropdown" on the screen
      And the toggle button is off
      And user clicks on the "address check box"
      Then user will be seeing "city input field" on the screen

    @PrepaidCardAutoReload
   # @USAT-8432
    Scenario: Non editable address field
     # Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
#      When user sees "address check box" on the screen
     # Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      #When user sees "reload dropdown" on the screen
      And the toggle button is off
      And user verifies if the address field is in non editable mode
      Then user sees that the value is present in the address field of manual flow and compares it against the registered value


    @PrepaidCardAutoReload
   # @USAT-8394
    Scenario: Data enetered will be saved
      #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      And the toggle button is off
      And user clicks on the "address check box"
      Then user will be seeing "city input field" on the screen
      And user enters "new city" in the "city input field"
      And user unchecks and checks the checkbox again
      Then user will be seeing "new city" on the entered value in the "city input field"

    @PrepaidCardAutoReload
   # @USAT-8397, @USAT-8399, @USAT-8401, @USAT-8403
    Scenario: Blank error messages for all fields
      #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      And the toggle button is off
      And user clicks on the "address check box"
      Then user sees blank errors are displayed if fields are left blank:
        | blank street address error | streetAddressBlankError |
        | blank city error           | cityBlankError          |
        | blank state error          | stateBlankError         |
        | blank zipcode error        | zipcodeBlankError       |

    @PrepaidCardAutoReload
    Scenario: Enabled fields data entry
     #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      And the toggle button is off
      And user clicks on the "address check box"
      Then user sees blank errors are displayed for address section if fields are left blank:
        | blank street address error | streetAddressBlankError |
        | blank city error           | cityBlankError          |
        | blank state error          | stateBlankError         |
        | blank zipcode error        | zipcodeBlankError       |

  Rule: Zipcode only accepts a value of 5 digits or an optional of - along with 4 digits
  (Examples of valid zipcodes format are xxxxx, xxxxx-xxxx)

#    @PrepaidCardAutoReload
#    Scenario: Invalid zipcode entry
#      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
#      When user sees "set up auto reload header" or "auto reload header" on the screen
#      And the toggle button is off
#      When user fills out the address form as below:
#        | Street address | genericStreetAddress |
#        | State          | genericState         |
#        | City           | genericCity          |
#      And user enters "yghy" in the "zip/postal code input field"
#      Then user will be able to select reload balance, enter credit card and cvv
##      And user clicks on the "city input field"
#      Then user clicks on the "schedule reload button"
#      And user sees "invalid zipcode error alert pop up" on the screen

    #Uncomment it

  Rule:
  - State would only be accepting valid State codes (example: MO, OH, CA etc)
  - State would not be accepting the whole name (Ex: Ohio, California are not valid)
  - No aplhanumberics, special characters are allowed

     #Uncomment it
#    @PrepaidCardAutoReload
#    Scenario: Invalid state entry
#      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
#      When user sees "set up auto reload header" or "auto reload header" on the screen
#      And the toggle button is off
#      And user fills out the address form as below:
#        | Street address  | genericStreetAddress |
#        | City            | genericCity          |
#        | zip/postal code | genericZipcode       |
#      When user enters "yghy" in the "state input field"
#      Then user will be able to select reload balance, enter credit card and cvv
#      And user clicks on the "schedule reload button"
#      Then user will be see the alert pop up for "invalid state error alert pop up" on the screen


    #@PrepaidCardAutoReload
    @ReloadAuto
   # @USAT-7989, @USAT-5870
    Scenario: Auto reload success flow
      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      When user sees "set up auto reload header" or "auto reload header" on the screen
      And the toggle button is off
      Then user will be able to select the following value - "$10" from "reload dropdown"
      And user will be able to select the following value - "$100" from "balance dropdown"
      Then user fills out the remaining feilds on the page and clicks on "schedule reload button"

#    @PrepaidCardAutoReload
  @ReloadAuto
    Scenario: Toggle off auto reload
      Given user launches the application and to navigate to prepaid card details page by entering valid email and password
      When user will be seeing "auto reload label" on the screen
      Then user looks for the status of reload and toggles it off if it is active


#    @PrepaidCardAutoReload
  @ReloadAuto
   # @USAT-8393
    Scenario: unchecking the box removes newly address fields
      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password

      #And the toggle button is off
      #And user clicks on the "address check box"
      And user scrolls down to the "address check box" on the screen and clicks it
      Then user will be seeing "city input field" on the screen
      And user clicks on the "uncheck address check box"
      Then new address fields will be removed from the screen


#    @PrepaidCardAutoReload
  @ReloadAuto
   # @USAT-8395
    Scenario: Unchecking the address check box displays previous data
     #Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      Given user launches the application and to navigate to prepaid card reload page by entering valid email and password
      And the toggle button is off
      And user checks the address checkbox and enters new data
      And user clicks on the "uncheck address check box"
      Then user sees that the value is present in the address field of auto flow and compares it against the registered value




