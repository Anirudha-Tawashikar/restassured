Feature: validating place API

  @Addplace
  Scenario Outline: verify if the place if the place is succesfully added using AddPlace
    Given Add place payload "<name>" "<language>" "<adderss>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is the success with the status code 200
    And "status" in response body is "OK"
    And verify place_Id created maps to "<name>" using "getplaceAPI"

    Examples: 
      | name   | language | adderss            |
      | ajhjhj | english  | world cross center |

  #| anirudha | marathi  | mumbai             |
  @Deleteplace
  Scenario: verify the delete place fuctionality is working
    Given delete payload
    When user calls "deleteplaceAPI" with "POST" http request
    Then the API call is the success with the status code 200
    And "status" in response body is "OK"
