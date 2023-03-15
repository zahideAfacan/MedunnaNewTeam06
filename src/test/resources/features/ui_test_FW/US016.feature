@US_016
  Feature: Create or Edit Patient by just Admin
    Background: Admin SignIn

      Given user patient is on medunna page
      Given user admin clicks account menu button
      When user admin clicks sign in button
      Then user admin enters credentials
        | username    | password |
        | AdminTeam06 | Team06+  |


      @TC01
      Scenario Outline: TC01_CreateTNew_Patient_byAdmin
        When user click on Administration button
        When user click on user management button
        Then user click on Create a new user
        Then user enters the login "<login>"
        And user enters the first name "<firstname>"
        And user enters the last name "<lastname>"
        And user enters the Email "<email>"
        And user enters the SSN "<ssn>"
        And user click on Activated button
        And user enters the Language "<language>"
        And user click on patient role
        And user click on save button
        And verify patient on the users list
        Examples:test_data
          | login | firstname | lastname | email          | ssn        | language |
          |Hassta |Hassta      |Guzel    |hassta@gmail.com|888-77-6666 | English  |



        @TC02
       Scenario: TC02_Admin can see all patient information
          When user click on Administration button
          When user click on user management button
          When user goes to last page
          Then users chose patient last patient and  see the all information


       @TC03
       Scenario: TC03_Admin can  have above items and following new item;id
         When user click on Items&Titles button
         When user click on patient from dropdown menu
         Then user click on Create A New User button
         Then verify id  always comes after patient creating


       @TC04 @Za
       Scenario: TC04_State should be provided as US state and cannot be blank
         When user click on Items&Titles button
         When user click on patient from dropdown menu
         Then user click on Create A New User button
         Then assert that State should be provided as US state and cannot be blank


       @TC05 @Za
       Scenario: Admin can delete any patient
         When user click on Items&Titles button
         When user click on patient from dropdown menu
         When user goes to last page
         When user chooses a patient to delete
         Then user click on delete button and confirm to delete
         Then verify the patient is not on the list
