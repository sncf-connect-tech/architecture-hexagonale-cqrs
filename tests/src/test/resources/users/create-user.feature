Feature: Create user

  Scenario: Create a user
    Given a user to create
    When I create this user
    Then the user is successfully created
