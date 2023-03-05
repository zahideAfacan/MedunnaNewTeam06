Feature: US_008
  @US_008_TC01
  Scenario: US_008_TC01

    Given go to medunna home page
    When click on sign in icon
    When enter patient username
    When enter patient password
    When click sign in button
    When click on MY PAGE icon and Make an Appointment button
    When enter a valid and unvalid appointment date time and verify

