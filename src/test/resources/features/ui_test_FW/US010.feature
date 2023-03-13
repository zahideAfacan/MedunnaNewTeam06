@US10
Feature: Staff Edit Patient
  Background: opening_medunna_website
    Given Launch browser and navigate to medunna.com
    Then Staff navigates to the sign in page
    Then Staff signs in
    Then Staff clicks on My Pages link
    Then Staff clicks on Search Patient link
    Then Staff enters the patient SSN number
    Then Staff clicks on Edit Button


  @US10_TC01
  Scenario: TC01
    Then Staff edits firstname
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC02
  Scenario: TC02
    Then Staff edits lastname
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC03
  Scenario: TC03
    Then Staff edits birthdate
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC04
  Scenario: TC04
    Then Staff edits email
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC05
  Scenario: TC05
    Then Staff edits phone
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC06
  Scenario: TC06
    Then Staff edits gender
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message


  @US10_TC07
  Scenario: TC07
    Then Staff edits blood group
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC08
  Scenario: TC08
    Then Staff edits address
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC09
  Scenario: TC09
    Then Staff edits description
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

  @US10_TC10
  Scenario: TC11
    Then Staff edits country
    Then Staff clicks on Save Button
    Then Staff verifies A Patient is updated with identifier <patient Id> message

#  @US10_TC11
#  Scenario: TC11
#    Then Staff edits user
#    Then Staff clicks on Save Button
#    Then Staff verifies A Patient is updated with identifier <patient Id> message


#  @US10_TC12
#  Scenario: TC12
#    Then Staff edits state-city
#    Then Staff clicks on Save Button
#    Then Staff verifies A Patient is updated with identifier <patient Id> message


#  @US10_TC13
#  Scenario: TC14
#    Then Staff verifies that all the registration info populated



