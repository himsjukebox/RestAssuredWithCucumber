Feature: To perform all CRUD Operations

  Scenario: To perform GET operation on Employee DB
    Given The Base URI is "http://localhost:3000/employees"
    When I perform the GET Operation
    Then Response code should be 200

  Scenario: To perform POST operation on Employee DB
    Given The Base URI is "http://localhost:3000/employees"
    When I provide with name "Bruce Wayne" and salary "50000123"
    When I perform POST operation
    Then Response code should be 201
