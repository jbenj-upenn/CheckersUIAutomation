Feature: User can make moves as orange in Checkers game

  Background: User is on Checkers game page
    Given user is on the Checkers game page
    And verify Checkers is set to new game

  @Checkers @UI @Smoke @Regression
  Scenario: User reads all spaces on board
    And user reads own orange pieces
    And user reads CPU blue pieces

  @Checkers @UI @Smoke @Regression
  Scenario: User reads clickable pieces and clickable spaces to move to
    And user reads first clickable
    And user reads second clickable
    And user determines first valid clickable
    And user determines second valid clickable
    And user determines valid jumpable pieces
    Then user determines best move

