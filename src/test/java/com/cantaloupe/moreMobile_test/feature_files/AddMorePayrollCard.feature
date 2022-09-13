Feature: Add More Payroll Card
  As a more app user, I want a to add a more payroll card to the app so that I am able to make a transaction
#  @USAT-7451, @USAT-5914

    @AddMorePayrollCard
 # @USAT-8881
  Scenario: Adding a more payroll card successfully
    Given user launches the application and to navigate to add more card payroll page by entering valid email and password
    When user enters a valid more payroll card number in respective input fields
    And user clicks on the "add more card button"
    Then More "added more card success page" should load successfully
    And user should see "more card added text" and "more card success text" on the screen


  @AddMorePayrollCard
 # @SmokeTest
  #@USAT-8889
  Scenario: Payroll card cannot be a set as a primary card
    Given user launches the application and to navigate to add more card payroll page by entering valid email and password
    When user enters a valid more payroll card number in respective input fields
    Then user sees that set as primary card option will not be available for the payroll card

  @AddMorePayrollCard
  #@USAT-8879
  Scenario: Already registered more card
    Given user launches the application and to navigate to add more card payroll page by entering valid email and password
    When user enters the already registered more payroll card and security code in respective input fields
    Then user clicks on the "add more card button"
    And More "add more card payroll page" should load successfully
    Then user will be seeing "more card registered alert pop up" on the screen

  @AddMorePayrollCard
 # @USAT-8876
  Scenario: Note for Please Contact Your Program Administrator text
    Given user launches the application and to navigate to dashboard after adding a payroll card by entering valid email and password
    When user clicks on the "add more card link"
    Then More "add more card payroll page" should load successfully
    And user should see "question mark image" and "dont have card text" on the screen

  @AddMorePayrollCard
  Scenario: Display last 4 digits of the card number
    Given user launches the application and to navigate to dashboard after adding a payroll card by entering valid email and password
    When user sees "profile link" on the screen
    Then user sees the added payroll card on the dashboard page

  @AddMorePayrollCard
  #@USAT-8886
  Scenario: Balance on the added card
    Given user launches the application and to navigate to dashboard after adding a payroll card by entering valid email and password
    When user sees "profile link" on the screen
    Then user sees the added payroll card and the balance as - "0.00" on dashboard page

  @AddMorePayrollCard
  #@USAT-8887
  Scenario: Navigation to payroll deduct card page and view the components
    Given user launches the application and to navigate to dashboard after adding a payroll card by entering valid email and password
    When user sees "profile link" on the screen
    Then user sees the balance for the added card

  Rule:
  - Only 19 digits are accepted as a card number
  - If the number is less than 19 digits, error will be thrown`
  - The input field will not accept any entry after entering 19 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed

    Background:
      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
      And More "add more card payroll page" should load successfully

    @AddMorePayrollCard
   # @USAT-8871
    Scenario: Enter a valid card number with 19 digits
      When user enters a valid 19 digit more card number - "6546768654165464165" in respective field
      Then the "add more card button" will be in enabled mode

    @AddMorePayrollCard
   # @USAT-8871
    Scenario Outline: Enter an invalid card number which is less then 19 digits
      When user enters "<invalid card number>" in the "more card number input field"
      And user does a random click on the screen
      Then user will be seeing "invalid more card number error" on the screen

      Examples:
        | invalid card number |
        | 6                   |
        | 65                  |
        | 6739845             |
        | 123456789123456789  |

    @AddMorePayrollCard
    #@USAT-8869
    Scenario Outline: only numbers are allowed from aplhanumeric characters
      When user enters "<invalid card number>" in the "more card number input field"
      Then user sees that only numbers are entered even though he enters alphanumeric characters for "security code input field"
      Examples:
        | invalid card number |
        | dfdsf76565878       |
        | 2132#@%Tasfdv       |

    @AddMorePayrollCard
   # @USAT-8870
    Scenario: error for blank more card input field
      When user enters "     " in the "more card number input field"
      And user does a random click on the screen
      Then user will be seeing "invalid more card number error" on the screen

    @AddMorePayrollCard
   # @USAT-8877
    Scenario: Invalid more card Alert pop up
      When user enters the invalid more card number as below: "6396213030038862426" and "8010"
      Then user clicks on the "add more card button"
      And More "add more card payroll page" should load successfully
      Then user will be seeing "invalid more payroll card alert pop up" on the screen


  Rule: For Scurity code field
  - Only 4 digits are accepted as security code
  - If the number is less than 4 digits, error will be thrown`
  - The input field will not accept any entry after entering 4 digits
  - No alphabets are allowed
  - No special characters are allowed
  - No blank spaces are allowed

    @AddMorePayrollCard
   # @USAT-8875
    Scenario Outline: Error message for security code input field less than 4 digits
      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
      When user enters "<invalid security code>" in the "security code input field"
      And user does a random click on the screen
      Then user sees "invalid security code error" on the screen
      Examples:
        | invalid security code |
        | 1                     |
        | 65                    |
        | 568                   |

    @AddMorePayrollCard
   # @USAT-8878
    Scenario: Invalid more card security code Alert pop up
      Given user launches the application and to navigate to add more card payroll page by entering valid email and password
      When user enters valid card and invalid security number
      Then user clicks on the "add more card button"
      Then user will be seeing "invalid security match alert pop up" on the screen

