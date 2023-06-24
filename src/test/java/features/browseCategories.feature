Feature: spotify browse
  @execute
  Scenario: browse all the categories
    Given when environment is up and working
    When user send the get request to get browse end point
    Then user should receive the response code 200.

  @execute1
  Scenario: browse categories with response code 201
    Given when environment is up and working
    When user send the get request to get browse end point
    Then user should receive the response code 201.

  @execute1
  Scenario: browse all the categories
    Given when environment is up and working
    When user send the get request to get browse end point
    Then user should receive the response code 200.