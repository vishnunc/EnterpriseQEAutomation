@ChallengePackage
Feature: New customer registration with purchase - [Lead, Performance pack, Club] 

Scenario Outline: New customer registration with purchase - [Lead, Performance pack, Club] 
	#Create new customer in TBB with order
#	Given I am on TBB home page
#	When I select Challenge pack "<pack>"
#	And I select "<packtype>" for buying
#	And I add to cart with "<flavor>","<packaging>","<recover>","<RPacking>" and "<qty>" options
#	When I view my cart
#	Then I should be able to validate Title, Qty, Price and Order summary
#	#And I should be able to validate "<subtotal>" and "<estimatedtotal>"
#	When I checkout
#	Then I should be able to provide email to begin checkout
#	When I skip offers to continue shopping
#	And I enter my shipping information "<fname>","<lname>","<phone>","<address>","<city>","<state>","<zip>"
#	And validate the QAS address
#	And I select shipping option as "<shipping>" to continue
#	Then shipping & handling and taxes should be updated
#	And when I enter payment details to continue
#	And I create an account with "<email>","<password>","<dob>","<gender>"
#	And I select "<coach>" as option for coach
#	And I submit order
#	Then I should be able to see a successful order placement with an Order ID
	#Verify the emails

	#Validate the Customer details in OIM
#	Given I am logged in to OIM
#	When I search for user with email in OIM
#	Then I should be able to validate the customer details in OIM
	#Validate the Customer details in ByDesign
	Given I am logged in to ByDesign
	When I search for customer with email in ByDesign
	Then I should be able to validate the customer details in ByDesign
	#Validate the Order details in ByDesign
	And I should be able to validate the order details in ByDesign
	#Validate the Customer details in EBS
	And I should be able to validate customer details in EBS
	#Validate the Order details in EBS
	And I should be able to validate order details in EBS
	#Validate the Customer details in COO
	Given I am logged in to COO
	When I search for the customer with email in COO
	Then I should be able to validate the customer details in COO
	#Validate the Order details in COO
	When I search for the order with order number in COO
	And I should be able to validate the order details in COO

Examples: Test data for the E2E scenario
|pack|packtype|flavor|packaging|recover|RPacking|qty|subtotal|estimatedtotal|email|fname|lname|phone|address|city|state|zip|shipping|password|dob|gender|coach|
|21DayFixEXTREME|21EPerformancePack:performancePack:4|Lemon|40|Orange|20|1|$160.00|$160.00||testing|ln|4695552221|3301 Exposition Blvd|Santa Monica|CA|90404|1|Testing1234|03-17-1986|Male|Yes|
	

