Feature: User can make moves as orange in Checkers game

  Background: User is on Checkers game page
    Given user is on the Checkers game page
    And verify Checkers is set to new game

  @Checkers @UI @Smoke @Regression
  Scenario: User begins game making a legal move
    Then user obtains all board spaces and pieces
    And user reads own orange pieces
    And user reads CPU blue pieces

@Checkers @UI @Smoke @Regression
  Scenario: User reads first clickable spaces
  And user reads first clickable
  And user reads second clickable
