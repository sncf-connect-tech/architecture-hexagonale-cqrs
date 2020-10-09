Feature: Delete user

  Scenario: Delete a user
    Given an existing user
    When I delete this user
    Then the user is successfully deleted
