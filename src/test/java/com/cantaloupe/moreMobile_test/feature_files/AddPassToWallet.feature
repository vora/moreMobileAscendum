Feature: Add To Apple Wallet
  As a more app user, I want see if the I am able to add the more card to my apple wallet
  #USAT-7992

  Scenario: Add to apple wallet
    Given user launches the application and to navigate to prepaid card details page by entering valid email and password
    When user sees "manual reload label" on the screen
    Then user should see the add to apple wallet button on the page and clicks on it


