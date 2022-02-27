@All
Feature: Login Functionalities

  Background:
    Given the user is on the login page

  @PERF-852
  Scenario Outline: Filling out with valid credentials <valid username>
    Then the user enter "<valid username>" and "<valid password>"
    Examples:
      | valid username  | valid password |
      | user7           | UserUser123    |
      | storemanager87  | UserUser123    |
      | salesmanager107 | UserUser123    |

  @PERF-853
  Scenario: After filling out with valid credentials, users access different pages.
    Then "Driver" should land on the "Quick Launchpad" page after login successfully
    Then "Sales Manager" or "Store Manager" should land on the "Dashboard" page after login successfully

  @PERF-854
  Scenario: The system should not allow users to access the application without providing valid credentials.
    Given copy the url after log in then log out paste the same url to browser and try to skip authentication step

  @PERF-855
  Scenario Outline: Filling out with invalid credentials <invalid username>
    Then the user enters invalid credentials "<invalid username>" and "<invalid password>" and after "Invalid username or password." message should be displayed for invalid credentials
    Examples:
      | invalid username | invalid password |
      | user7            | 1234567          |
      | director         | UserUser123      |
      | dennis           | bergkamp         |

  @PERF-856
  Scenario Outline: Filling out with no credentials.
    Then the user enters blank credentials "<blank username>" and "<blank password>" and  "Please fill out this field." message should be displayed for any empty field
    Examples:
      | blank username | blank password |
      | user7          |                |
      |                |                |

  @PERF-857
  Scenario: Password seen as a bullet sign.
    Given Users should see their password in bullet signs while typing

  @PERF-858
  Scenario: Forgot Password menu.
    Then User lands on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    Then Users can change their password with the username after clicking on "Forgot your password?" link

  @PERF-859
  Scenario: There is a remember me option on the login page.
    Given User can see "Remember me on this computer" link on the login page and it should be clickable

  @PERF-860
  Scenario: Enter key can be used by users.
    Given User can use "Enter" key from their keyboard on the login page after entering username and password

  @PERF-861
  Scenario: Drivers can see their own usernames.
    Given drivers can see own username in profile menu, after login successfully

  @PERF-862
  Scenario: Sales managers can see their own usernames.
    Given sales manager can see own username in profile menu, after login successfully

  @PERF-863
  Scenario: Store managers can see their own usernames.
    Given store manager can see own username in profile menu, after login successfully
