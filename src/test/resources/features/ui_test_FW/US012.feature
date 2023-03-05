@US_012
Feature: US_12
  @US_012_TC01
  Scenario: User (doctor) should be able to populate info in 'Create or edit an appointment'
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click sign out button

    And go to medunna home page
    When click on sign in icon
    When enter staff username
    When enter staff password
    When click sign in button
    When Click on MY PAGE icon and click on Search Patients and Enter the Patient SSN
    When click on Show Appointments button and Click on Edit button
    Then steff change status of appointment
    Then staff click save button











