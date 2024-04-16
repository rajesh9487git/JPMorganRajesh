Feature: Social Network functionality

  Scenario: User makes a post successfully
    Given an API endpoint to make a post
    When the user makes a post
    Then the post is created successfully with 201 status code

  Scenario Outline: User comments on a post successfully
     Given an API enpoint to post comments
     When the user makes a "<comment>" with following details
     Then the post should be created successfully with correct comment
    Examples:
      | comment |
      |how are you|

  Scenario: User makes a GET request for list of users
    Given an API enpoint to get list of users
    When the user makes a get request to fetch the list of users
    Then I validate the status code and first element name
    And I copy the userslist to a json file


#   In real API multiple postive and negative scenarios can be designed such as following
#   Scenarios related to correct and incorrect authentications for creating post, making pots and fetching list of users`
#   Passing valid and invalid tokens for creating post, making pots and fetching list of users`
#  We can create scenarios based on valid and invalid payloads
#  Trying to make comment on a invalid ID etc
#  Trying to access list of user with invalid credentials etc

#  In this FW I have implemented Spring boot
#  We can pass the values/parameters from the feature file itself, but to demonstrate different
#  approaches , I have passed the values from feature file and from json file also





