Feature: testing the getPlaylists
 Scenario Outline: testing playlist get feature
    Given When user send the get request to playlists
    Then response should be received with status code<status_code>
    And playlist name should be <playlist_name>

   Examples:
     | status_code    | playlist_name      |
     |200             |boom...boom....boom |




