Feature: Demo 


Background: User is looged in 
	Given I navigate to Maketrip page 
	Then  I Login 
	
@Test 
Scenario Outline: Verify user is able to check multiple flights for entered locations 
	When I enter "<ToCity>" as travelling from city 
	And I enter "<FromCity>" as travelling to city 
	And I click search button 
	Then Test is successfully passed 
	
	Examples: 
		|ToCity | FromCity| 
		|Delhi  | Mumbai  |