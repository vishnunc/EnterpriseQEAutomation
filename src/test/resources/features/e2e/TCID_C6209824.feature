@ChallengePackage
Feature: New customer registration with purchase - [Lead, Performance pack, Club] 

Scenario Outline: New customer registration with purchase - [Lead, Performance pack, Club] 
	Given I am on TBB home page
	When I select Challenge pack "<pack>"
	And I select "<packtype>" for buying
	And I add to cart with "<flavor>","<packaging>","<recover>","<RPacking>" and "<qty>" options
	When I view my cart
	Then I should be able to validate Title, Qty, Price and Order summary
	And I should be able to validate "<subtotal>" and "<estimatedtotal>"
	When I checkout
	Then I should be able to provide "<email>" to begin checkout
	When I skip offers to continue shopping
	And I enter my shipping information "<fname>","<lname>","<phone>","<address>","<city>","<state>","<zip>"
	And validate the QAS address
	And I select shipping option as "<shipping>" to continue
	Then shipping & handling and taxes should be updated
	And when I enter payment details to continue
	And I create an account with "<email>","<password>","<dob>","<gender>"
	And I select "<coach>" as option for coach
	And I submit order
	Then I should be able to see a successful order placement with an Order ID

Examples: Test data for the E2E scenario

|pack|packtype|flavor|packaging|recover|RPacking|qty|subtotal|estimatedtotal|email|fname|lname|phone|address|city|state|zip|shipping|password|dob|gender|coach|
|21DayFixEXTREME|cdp-grid:21dayfixextreme:21dperformancepackaa:performancepack:3:buynow|Lemon|32|Orange|20|1|$160.00|$160.00|testing_vn@yopmail.com|testing|vvv|4695552221|3301 Exposition Blvd|Santa Monica|CA|90404|1|Testing1234|03-17-1986|Male|No|
	

