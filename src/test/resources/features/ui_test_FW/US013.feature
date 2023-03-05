@US_013
Feature: US_13
   @US_013_TC01
  Scenario: US_13
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click on Request A Test button
    Then verify that have Glucose, Urea, Creatinine, Sodium as checkmark options
    When click on urea checkbox and save button
    When click sign out button











