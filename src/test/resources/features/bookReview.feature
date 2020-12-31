Feature: Test BookReview Endpoints

  Scenario: Test findAll
    Given The book reviews bellow
    When I send a Get to /api/v1/book-review
    Then I get the response json
    """
    {
      "data" : "nothing"
    }
    """
