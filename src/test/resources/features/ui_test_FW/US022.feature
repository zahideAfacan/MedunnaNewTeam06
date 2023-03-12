@US_022
Feature:

  Background:
    Given go to medunna home page
    When click on sign in icon
    Then enter staff username
    And enter staff password
    And click sign in button
    Then click My Pages

  @US_022_TC_01
  Scenario: US_022_TC_01
    And click search patient
    And enter patient ssn "816-54-6898"
    And click edit button
    When change name
    Then change lastname
    And change birthdate
    And change email
    And change phone
    And change gender
    And change the blood group
    And change address
    And add description
    And change country
    And click save and
    Then verify the saved items
#Then close the page

  @US_022_TC_02
  Scenario: US_022_TC_02
    And click search patient
    And enter patient ssn "816-54-6898"
    Then click on Show Appointments button
    And  click on edit appointment button
    And staff changes status of appointment
    And staff sends a text to Anamnesis
    And staff sends a text to  Treatment
    And staff sends a text to Diagnosis
    And staff sends a text to Prescription
    And staff sends a text to description
    And staff selects a physician
    Then staff clicks save button
  And staff verifies popup message "The Appointment is updated"
And staff verifies the changes
And close the page

    @US_022_TC_03
    Scenario: US_022_TC_03
      And click search patient
      And enter patient ssn "816-54-6898"
      Then click on Show Appointments button
      And  click on edit appointment button
      And staff changes status of appointment
      And staff sends clear key to Anamnesis
      And staff sends clear key to  Treatment
      And staff sends clear key to Diagnosis
      And staff sends a text to Prescription
      And staff sends a text to description
      And staff selects a physician
      Then staff clicks save button
      And staff verifies popup message "The Appointment is updated"
      And staff verifies the changes
      And close the page