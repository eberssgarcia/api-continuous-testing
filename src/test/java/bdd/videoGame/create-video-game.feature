@video_game
Feature: Crear un Video Game
  Yo como QA
  Quiero poder ver los resultados de las pruebas
  Para saber si el software funciona correctamente

  Background:
#    * configure ssl = true
    And header Content-Type = 'application/json'

  @video_game_01
  Scenario Outline: Crear Board de Trello
    Given url urlVideoGame
    And path '/api/v2/videogame'
    And request read(<body_request>)
    When method post
    Then status 200
    And print response
    And match response == '#object'
    * string expectedSchema = read('../../jsonSchemas/videoGame/create-video-game-200.json')
    * string currentResponse = response
    * def schemaUtils = Java.type('util.JSONSchemaUtil')
    * assert schemaUtils.isValid(expectedSchema, currentResponse)
    Examples:
      | body_request                                                        |
      | '../../jsonBodyRequest/videoGame/create-video-game-happy-path.json' |