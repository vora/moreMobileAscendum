Feature: Click to Pay
  As a more app user, I want to see if the click to pay registration modal pop up is displayed
  #USAT-8237 #USAT-6287

  #USAT-6886
  Scenario: Toggle button displays for a new user
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user sees "reload card header" on the screen
    Then toggle button will be displayed under security code field for the first time user

  #USAT-6906
  Scenario: Deactivate click to pay
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user sees "reload card header" on the screen
    Then toggle button will be displayed under security code field for the first time user
    And user deactivates the click to pay by turning the toggle button off and sees classic manual reload screen

  #USAT-6925
  Scenario: Enroll in click to pay displays master card registration
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user enters card number, expiry date and cvv in respective fields and clicks on click to pay button
    Then toggle button will be displayed under security code field for the first time user
    And user should be displayed with master card registration modal pop up

  #USAT-7197
  Scenario: Confirmation pops up for master card pop up
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user enters card number, expiry date and cvv in respective fields and clicks on click to pay button
    Then user should be displayed with master card registration modal pop up
    And user clicks on cross icon and confirmation pop up will be displayed

  #USAT-6926,  #USAT-6927
  Scenario: Click on Cancel and Return to Merchant buttons
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user enters card number, expiry date and cvv in respective fields and clicks on click to pay button
    Then user should be displayed with master card registration modal pop up
    And user clicks on cross icon and confirmation pop up will be displayed
    Then user should return to the default manual reload screen on clicking on return to merchant button

  #USAT-6915 #USAT-7198
  Scenario: Prefilled email, country and mobile code
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user enters card number, expiry date and cvv in respective fields and clicks on click to pay button
    Then user should be displayed with master card registration modal pop up
    And user clicks on cross icon and confirmation pop up will be displayed
    Then user sees prefilled email, country and mobile fields

  #USAT-7202
  Scenario: Update contact information
    Given user launches the application and navigates to manual or auto reload cancel page by entering valid email and password
    When user enters card number, expiry date and cvv in respective fields and clicks on click to pay button
    Then user should be displayed with master card registration modal pop up
    And user updates the contact information by clicking on confirm button
