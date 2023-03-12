@US_027
Feature:
  @US27_TC_01
  Scenario:US27_TC_01 User send send message without login
  Given go to medunna home page
    When user clicks contact link
    And user sends name and surname
    And user sends email
    And user sends subject
    And user sends a message
    Then user patient click send  button
    And user checks the message success
   # Then close the application

  #@US27_TC_02
 #Scenario:US27_TC_02 Admin verifies created Message
    Given go to medunna home page
   Then user admin clicks account menu button
    When user admin clicks sign in button
    Then user admin enters credentials
      | username    | password |
      | AdminTeam06 | Team06+  |
    Then user admin clicks itemTitles
   And user admin clicks Messages

   Then user admin verifies created message

  #@US_027_TC_03
 # Scenario: US_027_TC_002 Name, Email, Subject cannot be left blank
    #Given go to medunna home page
   # When user clicks contact link
    #And user sends a message
   # Then user patient click send  button
    #Then verify Name, Email, and Subject fields are required to send a message successfully.
   # Then close the application
