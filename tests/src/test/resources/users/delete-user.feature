Feature: Delete user

  Scenario: Delete a user
    Given an existing user
    When I delete this user
    Then the user is successfully deleted

  Scenario: Trying to delete a user that doesn't exist should fail
    When I try to delete a user that doesn't exist
    Then the user deletion is rejected with a not found error
