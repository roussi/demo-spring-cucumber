Feature: Test greeting endpoints

  Scenario: Test greeting endpoint
    When I send a Get to /greeting/abdel
    Then I get the response
      | message      | label |
      | hello, abdel | test  |
