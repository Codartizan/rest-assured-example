@API @RG @post
Feature: Create New Employee Test

  Scenario: Create new employee test
    Given new employee object created
    When send POST the request
    Then the status code is 200
