@US021
Feature: US021
  @US021_TC01
  Scenario: US021_TC01
    Given go to medunna home page
    When click on sign in icon
    When enter admin username
    When enter admin password
    When click sign in button
    When click on Administration icon and User management button
    When find user and click on View button and verify can view people info
    When close the application

  @US021_TC02
  Scenario: US021_TC02
    Given go to medunna home page
    When click on sign in icon
    When enter admin username
    When enter admin password
    When click sign in button
    When click on Administration icon and User management button
    When find user and click on Edit button and activate or deactivate user and verify
    When give a role user and verify
    When close the application

  @US021_TC03
  Scenario: US021_TC03
    Given go to medunna home page
    When create a user
    Given go to medunna home page
    When click on sign in icon
    When enter admin username
    When enter admin password
    When click sign in button
    When click on Administration icon and User management button
    When delete user and verify
    When close the application