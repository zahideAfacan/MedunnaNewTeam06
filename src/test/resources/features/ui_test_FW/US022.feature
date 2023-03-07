@US_022
  Feature:
    Background:
      Given go to medunna home page
      When click on sign in icon
      Then enter staff username
      And enter staff password
      And click sign in button
    @US_022_TC_01
    Scenario: US_022_TC_01
      Then click My Pages
      And click search patient
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