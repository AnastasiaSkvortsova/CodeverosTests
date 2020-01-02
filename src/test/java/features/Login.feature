Feature: Logging with existing account

  Scenario: Successful logging
    Given a web browser is at Codeveros Sign In page
    When user enters "myUserName" as a Username_
    And user enters "myP" as a Password_
    And user click Sign In button
    Then Codeveros home page is shown

  Scenario Outline: Registration is not available when mandatory fields are empty
    Given a web browser is at Codeveros Sign In page
    When user enters "<userName>" as a Username_
    And user enters "<password>" as a Password_
    And user click Sign In button
    Then Sign In button stays inactive
    Examples:
      |userName      |password    |
      |              |            |
      |              |myP         |
      |newUserName   |            |

  Scenario Outline: Failed login with invalid credentials
    Given a web browser is at Codeveros Sign In page
    When user enters "<userName>" as a Username_
    And user enters "<password>" as a Password_
    And user click Sign In button
    Then Failed login message on Codeveros Sign In page is shown
    Examples:
      |userName      |password    |
      |myUserName    |myP1        |
      |newUserName   |myP         |


