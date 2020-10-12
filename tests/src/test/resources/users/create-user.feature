Feature: Create user

  Scenario: Create a user
    Given a user to create
    When I create this user
    Then the user is successfully created

  Scenario: Trying to create a user that already exists should fail
    Given an existing user
    When I try to create a user with the same email address
    Then the user creation is rejected with a conflict error
