Feature: Add More Prepaid Card
  As a more app user, I want a to add a more prepaid card to the app so that I am able to make a transaction
  #USAT-7451, USAT-5914
#
#  @Enhancement

#  @AddMorePrepaidCard
##USAT-8848, USAT-8834
#  Scenario: Adding a more card successfully
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters a valid more prepaid card number in respective input fields
#    And user clicks on the "add more card button"
#    Then More "added more card success page" should load successfully
#    Then user should see "more card added text" and "more card success text" on the screen

#  @AddMorePrepaidCard
##USAT-8848, USAT-8834
#  Scenario: Adding a more card successfully
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters a valid more prepaid card number in respective input fields
#    And user clicks on the "add more card button"
#    Then More "added more card success page" should load successfully
#    And user should see "more card added text" and "more card success text" on the screen
#
#
#  @AddMorePrepaidCard
##USAT-8848, USAT-8834
#  Scenario: Adding a more card successfully
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters a valid more prepaid card number in respective input fields
#    And user clicks on the "add more card button"
#    Then More "added more card success page" should load successfully
#    And user should see "more card added text" and "more card success text" on the screen
#

  @AddMorePrepaidCard
#  @SmokeTest
#USAT-8846
  Scenario: Already registered more card
    Given user launches the application and to navigate to add more card page by entering valid email and password
    When user enters a existing more prepaid card number in respective input fields
    And user clicks on the "add more card button"
    Then user sees "more card registered alert pop up" on the screen
  Then user should see "more card registered alert pop up" on the screen


  @AddMorePrepaidCard
    #USAT-8843
  Scenario: Note for Please Contact Your Program Administrator text
    Given user launches the application and to navigate to add more card page by entering valid email and password
    When user sees "add more card button" on the screen
    Then user should see "question mark image" and "dont have a card text" on the screen

  @AddMorePrepaidCard
    #USAT-8853
  Scenario: Display last 4 digits of the card number
   # Given user launches the application and to navigate to dashboard after adding a card by entering valid email and password
    Given user launches the application and to navigate to dashboard after adding a prepaid card by entering valid email and password
    When user sees "profile link" on the screen
    Then user sees the added prepaid card on the dashboard page


#  Scenario: Display last 4 digits of the card number
#    Given user launches the application and to navigate to dashboard after adding a prepaid card by entering valid email and password
#    When user sees "profile link" on the screen
#    Then user sees the added prepaid card on the dashboard page

  @AddMorePrepaidCard
  #@USAT-8886
  Scenario: Balance on the added card
    Given user launches the application and to navigate to dashboard after adding a prepaid card by entering valid email and password
    When user sees "profile link" on the screen
    Then user sees the card and the balance as - "0.00" on dashboard page


#
#    ################################
#
#
#
#
#
#
#
#
#    #USAT-8838,
#  Scenario: Error message for add more card input field
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters "1234567" in the "more card number input field"
#    And user does a random click on the screen
#    Then user sees "invalid more card number error" on the screen
#
#
#      #USAT-8835, USAT-8836 , USAT-8837, USAT-8838,
#  Scenario: Only Numbers with 19 limit are allowed for more card input field
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters a valid 19 digit more card number - "6396212035942168399" in respective field
#    Then the "invalid more card number error" should not be displayed on the screen
#
#
#          #USAT-8839, USAT-8840 , USAT-8841
#  Scenario: Only Numbers with 19 limit are allowed for more card input field
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters a valid security code - "1111" in respective field
#    Then the "invalid security code error" should not be displayed on the screen
#
#
#     #USAT-8842,
#  Scenario Outline: Error message for security code input field
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters "<invalid security code>" in the "security code input field"
#    And user does a random click on the screen
#    Then user sees "invalid security code error" on the screen
#
#    Examples:
#      | invalid security code |
#      | 11                    |
#
#
#  @SmokeTest
# #USAT-8844
#  Scenario: Invalid more card Alert pop up
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters the invalid more card number as below:
#      | More Card Number | moreCardNumber |
#      | Security Code    | securityCode   |
#    And user clicks on the "add more card button"
#    Then user sees "invalid more card alert pop up" on the screen
#
#
#  @Regression
#         #USAT-8845
#  Scenario: Invalid more card security match Alert pop up
#    Given user launches the application and to navigate to add more card page by entering valid email and password
#    When user enters the invalid security as below:
#      | More Card Number | moreCardNumber |
#      | Security Code    | securityCode   |
#    And user clicks on the "add more card button"
#    Then user sees "invalid security match alert pop up" on the screen
#
#
#


    ################################
  Rule:
  - Only 19 digits are accepted as a card number
  - If the number is less than 19 digits, error will be thrown`
  - The input field will not accept any entry after entering 19 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed

    Background:
      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
      And More "add more card page" should load successfully


    @AddMorePrepaidCard
   # @USAT-8871
    Scenario: Enter a valid card number with 19 digits
      When user enters a valid 19 digit more card number - "6396212035279094391" in respective field
      Then the "add more card button" will be in enabled mode

    @AddMorePrepaidCard
    #@USAT-8871
    Scenario Outline: Enter an invalid card number which is less then 19 digits
      When user enters "<invalid card number>" in the "more card number input field"
      And user does a random click on the screen
      Then user will be seeing "invalid more card number error" on the screen

      Examples:
        | invalid card number |
        | 6                   |
#        | 65                  |
#        | 6739845             |
#        | 123456789123456789  |

    @AddMorePrepaidCard
   # @USAT-8869
    Scenario Outline: only numbers are allowed from aplhanumeric characters
      When user enters "<invalid card number>" in the "more card number input field"
      Then user sees that only numbers are entered even though he enters alphanumeric characters for "security code input field"
      Examples:
        | invalid card number |
        | dfdsf76565878       |
#        | 2132#@%Tasfdv       |

#    @AddMorePrepaidCard
#   # @USAT-8869
#    Scenario Outline: no alphabets or special characters are allowed
#      When user will be seeing "more card number input field" on the screen
#      Then user sees that no value is entered after entering alphabets or special characters - "<invalid card number>" in "more card number input field"
#      And user does a random click on the screen
#      Then user will be seeing "invalid more card number error" on the screen
#      Examples:
#        | invalid card number |
#        | sdfghkjvbl          |
#        | @#$%&*%$^           |
##        | DFGHKJ$%^&          |

    @AddMorePrepaidCard
   # @USAT-8870
    Scenario: error for blank more card input field
      When user enters "     " in the "more card number input field"
      And user does a random click on the screen
      Then user will be seeing "invalid more card number error" on the screen

    @AddMorePrepaidCard
   # @USAT-8877
    Scenario: Invalid more card Alert pop up
      When user enters the invalid more card number as below: "1238765645657687678" and "1265"
      Then user clicks on the "add more card button"
      And More "add more card page" should load successfully
      Then user will be seeing "invalid more card alert pop up" on the screen


  Rule: For Scurity code field
  - Only 4 digits are accepted as security code
  - If the number is less than 4 digits, error will be thrown`
  - The input field will not accept any entry after entering 4 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed

    @AddMorePrepaidCard
   # @USAT-8875
    Scenario Outline: Error message for security code input field less than 4 digits
      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
      When user enters "<invalid security code>" in the "security code input field"
      And user does a random click on the screen
      Then user sees "invalid security code error" on the screen
      Examples:
        | invalid security code |
        | 1                     |
#        | 65                    |
#        | 568                   |

#    @AddMorePrepaidCard
#    Scenario Outline: no alphabets or special characters are allowed for security code field
#      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
#      When user enters "<invalid security code>" in the "security code input field"
#      Then user sees that no value is entered after entering alphabets or special characters - "<invalid security code>" in "security code input field"
#      And user does a random click on the screen
#      Then user will be seeing "invalid security code error" on the screen
#      Examples:
#        | invalid security code |
#        | sdfghkjvbl            |
##        | @#$%&*%$^             |
##        | DFGHKJ$%^&            |

#    @AddMorePrepaidCard
#   # @USAT-8873
#    Scenario Outline: only numbers are allowed from aplhanumeric characters for security code
#      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
#      When user enters "<invalid card number>" in the "security code input field"
#      Then user sees that only numbers are entered even though he enters alphanumeric characters for "security code input field"
#      Examples:
#        | invalid card number |
#        | dfdsf76565878       |
##        | 2132#@%Tasfdv       |

#    @AddMorePrepaidCard
#   # @USAT-8874
#    Scenario: error for blank security code input field
#      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
#      When user enters "1234567890098765432" in the "more card number input field"
#      When user enters "     " in the "security code input field"
#      And user does a random click on the screen
#      Then user will be seeing "invalid security code error" on the screen

    @AddMorePrepaidCard
   # @USAT-8878
    Scenario: Invalid more card security code Alert pop up
      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
      When user enters the invalid security as below: "6396212035199831294" and "1234"
      Then user clicks on the "add more card button"
      Then user will be seeing "invalid security match alert pop up" on the screen





