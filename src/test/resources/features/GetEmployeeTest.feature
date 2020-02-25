@API @RG @get
Feature: Get Employee List

  Scenario: Get all employee test
    Given get all employees from dummy api
    When send GET the request
    Then the status code is 200
    And the response is matching the employeeListSchema.json


  Scenario: Get all employee test - NOT FOUND
    Given get all employees from dummy api with an invalid path
    When send GET the request
    Then the status code is 404
