@contactus
 Feature: User send message without login
  @post_message
  Scenario:
    Given user goes to medunna message page
    Then posts a message and user validates message
   @get_all_message
Scenario:

  Given user goes to medunna all message  page
  Then gets all messages and validates created message
