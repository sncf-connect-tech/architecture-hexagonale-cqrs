Feature: Get toto
  Go get him

  Scenario: get normal toto
    Given an existing toto
    When I get toto
    Then toto is successfully retrieved