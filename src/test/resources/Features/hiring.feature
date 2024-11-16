#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
#I want to use this template for my feature file
#
#@tag1
#Scenario: Title of your scenario
#Given I want to write a step with precondition
#And some other precondition
#When I complete action
#And some other action
#And yet another action
#Then I validate the outcomes
#And check more outcomes
#
#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step
#
#Examples:
#| name  | value | status  |
#| name1 |     5 | success |
#| name2 |     7 | Fail    |
Feature: Check that a new employee was succesfully hired
  
  As Admin HR user, I want to hire a new employee to fill an open position

  Scenario Outline: Create a new valid employee with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on Login
    And user selects Recruitment
    And press +Add button
    And fill the Add Candidate form using <firstName>, <middleName>, <lastName> and <eMail>
    And press Save
    And press Schedule Interview
    And Save that scheduled interview
    And that interview is marked as Passed
    And a Job is offered to the new candidate
    And the candidate is Hired
    Then new employee is listed on Recruitment list as Hired

    Examples: 
      | username | password |	firstName	| middleName	|	lastName	|	eMail	|
      | Admin    | admin123 |	firstName	| middleName	|	lastName	|	fake@email.com	|
