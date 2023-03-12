@US17
Feature: Room creation/View/Update/Delete

  Background:

    Given Admin goes to Medunna url
    And Admin goes to the sign in page
    And Admin enters his credentials in popup window
    And Admin clicks on Sign in button
    And Admin navigates to the Items-Titles and clicks on Room

  @US17_TC01
  Scenario: US17_TC01

    And Admin clicks on Create a new Room button
    And Admin fills the Room number and Price and left blank the Decription and clicks on save button
    And Admin verify A new Room is created with identifier message

  @US17_TC02
  Scenario: US17_TC02

    And Admin clicks on Create a new Room button
    And Admin clicks on save button and verifies the This field is required message  about Price
    And Admin fills the Room number and Price and clicks on save button
    And Admin verify A new Room is created with identifier message

  @US17_TC03
  Scenario Outline: US17_TC03

    And Admin clicks on Create a new Room button
    And Admin fills the required fields
    And Admin verifies room type as "<status>" are can be set for the room

    Examples:status
      | status         |
      | TWIN           |
      | DELUXE         |
      | PREMIUM_DELUXE |
      | SUITE          |
      | DAYCARE        |

  @US17_TC04
  Scenario: US17_TC04
    And Admin clicks on Create a new Room button
    And Admin picks old date from Created Date part
    And Admin fills the Room number and Price and left blank the Decription and clicks on save button
#    And Admin verify A new Room is created with identifier message
    And admin goes to the last page
    And Admin verify created Date is not match with old date

  @US17_TC05
  Scenario: US17_TC05

    And Admin clicks on first Edit button
    And Admin updates the room number, room type and price
    And Admin fills the Room number and Price and clicks on save button
    And Admin verify A new Room is updated with identifier message

  @US17_TC06
  Scenario: US17_TC06

    And Admin clicks on first Delete button
    And Admin clicks on delete button from opened popup
    And Admin verify Delete Success message
