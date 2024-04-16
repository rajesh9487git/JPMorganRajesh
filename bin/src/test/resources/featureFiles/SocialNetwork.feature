Feature: Social Network functionality

#  Scenario: User makes a post successfully
#    Given an API endpoint to make a post
#    When the user makes a post
#    Then the post is created successfully with 201 status code

  Scenario Outline: User comments on a post successfully
     Given an API enpoint to post comments
     When the user makes a "<comment>" with following details
    Examples:
      | comment |
      |how are you|



#    And there is a post with id 1
#    When the user comments on the post with id 1 with the comment "Great post!"
#    Then the comment is added successfully
#    And the comment has the correct content
#
#  Scenario: User tries to make a post without specifying the title
#    Given the user with id 3 exists
#    When the user makes a post without specifying the title
#    Then the post creation fails
#    And the error message is returned
#
#  Scenario: User tries to comment on a non-existing post
#    Given the user with id 4 exists
#    When the user tries to comment on a non-existing post with id 100
#    Then the comment operation fails
#    And the error message is returned
