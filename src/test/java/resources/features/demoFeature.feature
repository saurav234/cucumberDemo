Feature: Fizzbuzz test feature
  Scenario: Play Fizzbuzz to get Buzz
    Given Create a fizzbuzz gameplay
    When I play with number 3
    Then The result was Buzz


  Scenario: Play Fizzbuzz to get Fizz
    Given Create a fizzbuzz gameplay
    When I play with number 55
    Then The result was Fizz

