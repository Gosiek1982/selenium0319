@tag
Feature: Flight reservation
  I want to login and reserve some flight

  @tag1
  Scenario: login to the app
    Given I open main page
    When I fill the login form with login "Gosiek1982" and pass "Gosiek1982"
    Then I should see the flight reservation form
    
    Scenario: reserve flight
    Given I open main page
    When I fill the login form with login "Gosiek1982" and pass "Gosiek1982"
    And I choose "2" passengers
    And I choose one way trip
    And I start from "London" at month: "6" day: "12"
    And I end at "Paris" at month: "3" day: "25"
    And I want to fly first class using "Pangea AirLines"
    Then I submit first level of my flight reservation
    
    
    