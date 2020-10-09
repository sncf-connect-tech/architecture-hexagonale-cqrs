Feature: Get user

  Scenario: Get a user
    Given an existing user
    When I get this user
    Then the user is successfully retrieved
