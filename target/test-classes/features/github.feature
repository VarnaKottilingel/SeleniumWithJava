Feature: Create a new repository on GitHub

  Scenario: TC_001 User should be able to sign in to GitHub
    Given the user is on the GitHub login page
    When the user logs in with username and password
    When the user creates a new repository named "Rep1"
    Then the repository should be created successfully
    When the user clicks on "Settings" tab
    And the user clicks on Delete this repository
    Then the repository should be deleted successfully
