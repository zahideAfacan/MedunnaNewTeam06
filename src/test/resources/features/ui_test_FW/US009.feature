@Change_password
  Feature:US_009User_should_be_able_to_edit_the_Password_after_login

      Background: Sign_In
          Scenario: Sign in medunna page
      Given users on medunna_url page
      When click on users icon
      And clicks on Sign In option
      And enters username in username input
      And enters password in password input
      And clicks on Remember Me checkbox
      And clicks on Sign In submit button
      And clicks on account menu
      Then clicks on password from dropdown menu

      @US009_TC01
      Scenario:At_least_1_Lowercase_char_password
      Then enter at least one lowercase char
      Then verify the level chart change


     @US009_TC02
     Scenario: At_least_1_Uppercase_char_password
     Then enter at least one uppercase char
     Then verify the level chart change

      @US009_TC03
      Scenario: At_least_1_Digit_password
      Then enter at least one digit
      Then verify the level chart change

      @US009_TC04
      Scenario:  At_least_1_Special_password
      Then enter at least one special char
      Then verify the level chart change

      @US009_TC05
      Scenario:  At_least_seven_char_password
      Then enter at least seven char
      Then verify the level chart change

      @US009_TC06
      Scenario:  Old password should not be used
      Then enter old password in new password input
      Then verify the level chart change
        And close the application



