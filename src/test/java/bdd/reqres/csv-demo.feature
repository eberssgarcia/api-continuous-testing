@reqres
Feature: Read csv demo

  Background:
    * configure ssl = false

  @reqres-01
  Scenario Outline: Read csv file
    Given url urlRequest
    And path id
    When method get
    * print 'Response: ', response
    Then status 200
    Examples:
      | read('classpath:data/read-data.csv') |

#  @reqres-02
#  Scenario Outline: Get request with CSV table - multiple columns
#    Given url 'https://reqres.in/api/users/'
#    And path id
#    When method get
#    * print 'User name: ', name
#    * print 'Message: ', message
#    * print 'Response: ', response
#    Then status 200
#    Examples:
#      | read('classpath:data/read-data-multiple.csv') |