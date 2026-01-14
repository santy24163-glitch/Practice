Feature: This it to validate ANZ_PAP Application

  @scenario1
  Scenario: This is to login to Application using BA
    Given User is in HomPage
    When Enters BA Username and Password
    And  Clicks on login
    Then User should be navigated inside ANZ_PAP Portal
    And Logo should be displayed correctly

  @scenario2 @Test_Case_2_3
  Scenario: Verify all the user are able to  access AZ Company Portal through Sales force

    When i Logged into PAP Application using BA as a user
    And I navigate to login to with the Henry Williams user
    Then all the users should be navigated inside AZ Company Portal



