@US_DB030
  Feature: Room validation
    Scenario:Validate rooms with DB
      Given user connects to database
      Then hen get all "room_number" as a list from "room"
      And Then verify list contains id "418921939"
      And close the connection
