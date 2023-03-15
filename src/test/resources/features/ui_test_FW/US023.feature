@US023
  Feature:Patient Test results by Staff
    Background:Sign in as a staff

      Given go to medunna home page
      When click on sign in icon
      Then enter staff username
      And enter staff password
      And click sign in button

        @US023_TC01
        Scenario:TC01 user (Staff) can search about patient by SSN id
        When click My Pages
          And click search patient
          And enter patient ssn "356-78-6251"

       @US023_TC02
       Scenario: User should navigate to Show appointments
         When click My Pages
         And click search patient
         And click on any patient's Show Appointments
         And edit patient tests clicking on Show test
         And click on view results
         And  edit results where they will see selected tests by Doctor
         And  verify updating test resut

       @US023_TC03
       Scenario: Staff will view or update the result info
         When click My Pages
         And click search patient
         And click on any patient's Show Appointments
         And edit patient tests clicking on Show test
         And click on view results
         And Staff will view or update the result info