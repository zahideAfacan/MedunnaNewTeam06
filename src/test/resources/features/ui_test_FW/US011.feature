@US_011
Feature: US_011
  @US_011_TC01
  Scenario: User (doctor) can see their appointments list and time slots on My Appointments
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button
    Then close the application

