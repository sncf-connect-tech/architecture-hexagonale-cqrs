Feature: Update user

  Scenario: Update a user
    Given an existing user
    When I update this user
    Then the user is successfully updated
