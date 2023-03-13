@DB031
Feature: Messages Validation
  @US031_TC02
  Scenario: Validate messages
    Given user connects to database
    When get all "last_name" as a list from "physician"
    Then verify list contains "Masallah"
    And close the connection

