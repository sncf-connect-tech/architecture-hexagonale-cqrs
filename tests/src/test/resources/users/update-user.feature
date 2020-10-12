Feature: Update user

  Scenario: Update a user
    Given an existing user
    When I update this user
    Then the user is successfully updated

  Scenario: Trying to update a user with the the same name should fail
    Given an existing user
    When I try to update this user with the same name
    Then the user update is rejected with a bad request error

  Scenario: Trying to update a user that doesn't exist should fail
    When I try to update a user that doesn't exist
    Then the user update is rejected with a not found error
