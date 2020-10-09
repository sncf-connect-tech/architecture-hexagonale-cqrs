Feature: Get all users

  Scenario: Get all users
    Given 10 existing users
    When I get all the users
    Then all the existing users are successfully retrieved
