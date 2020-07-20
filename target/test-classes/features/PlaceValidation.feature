Feature: Validatinf place APIs 

@AddPlace @Regression
Scenario Outline: verify if place has added using add place API 
	Given Add place payload "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "POST" http request 
	Then the API call is success with status code 200 
	And "status" in response body is "OK"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	
	Examples:
	|name		|	language	|	address		|
	|Mukesh		|	English		|	1425 S Wolf	|
	#|Mukki		|	Hindi		|	1234234 w Wolf	|
	
@DeletePlace @Regression
Scenario: verify if place has been deleted using delete place API 
	Given DeletePlace payload
	When user calls "deletePlaceAPI" with "POST" http request 
	Then the API call is success with status code 200 
	And "status" in response body is "OK"