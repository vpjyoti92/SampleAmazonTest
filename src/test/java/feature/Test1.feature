Feature: Validating selecting the mask

  @Test @Regression
  Scenario: Successfull selecting object on amazon
    Given Launch Google using Chrome browser and https://www.amazon.in/ url
    Then I search for N95 masks in the search box
    Then I submit the search
    Then I select the first option
    Then I switch the window
    Then validate the price is 190
    And also validate the seller is RK World Infocom Pvt Ltd



