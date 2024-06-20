@create-board
Feature: Crear Board de Trello
  Yo como QA
  Quiero poder ver los resultados de las pruebas
  Para saber si el software funciona correctamente

  Background:
#    * configure ssl = true
    And header Content-Type = 'application/json'

  @TRELLO_01
  Scenario Outline: Crear Board de Trello
    Given url urlBase
    And path '/1/boards'
    And param key = apiKey
    And param token = apiToken
    And request { "name": "<name>" }
    When method post
    Then status 200
    And print response
    And match response == '#object'
    And match response.name == "<name>"
    And match response.name == 'Board de Prueba'
    * def idBoard = response.id
    * print idBoard
    * string expectedSchema = read('../../jsonSchemas/trello/create-board-200.json')
    * string currentResponse = response
    * def schemaUtils = Java.type('util.JSONSchemaUtil')
    * assert schemaUtils.isValid(expectedSchema, currentResponse)
    Examples:
      | name            |
      | Board de Prueba |
