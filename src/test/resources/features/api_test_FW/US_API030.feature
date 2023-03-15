 @US030_API
  Feature: Room creation
    Scenario: Validate all rooms with API creating
    Then user sends post request for creating room
    Then user sends get request for reading room
      Then user sends put request for updating room
     Then user sends delete request for deleting room
