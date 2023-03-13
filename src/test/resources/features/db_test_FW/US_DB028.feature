@DB028
Feature: Messages Validation
  @US028_TC03
  Scenario: Validate messages
    Given user connects to database
    When get all "message" as a list from "cmessage"
    Then verify list contains "Bir gül açılmaz yüzün tek verse bin gül-zare su"
    And close the connection


