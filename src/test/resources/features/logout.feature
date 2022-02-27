@AllLogout
Feature: Logout Functionalities
  Background:
    Given the user is on the login page

  @PERF-877
  Scenario: User is able to log out.
    Given "user" can log out by using log out button inside profile info and ends up in login page.

  @PERF-878
  Scenario: User cannot go back to the home page.
    Given "user" cannot go to the home page again by clicking the step back button after successfully logged out.

  @PERF-879
  Scenario: User must be logged out if user close the tab.
    Given The "user" must be logged out if the user close the tab (if there are multiple open tabs in the app, close all of them)

  @PERF-880
  Scenario: Keyboard
    Given The "user" must be logged out if the user is away from keyboard for three minutes