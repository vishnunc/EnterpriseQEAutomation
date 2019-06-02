@BYD
Feature: ByDesign Customer Details Verification

  Scenario Outline: Verifying the customer details in ByDesign
    Given I am on ByDesign Home Page
    When I enter "<username>" , "<pwd>" to login BYDesign
    And I click on customers option from search menu
    When I enter "<email>" and click on search
    Then I verify "<custno>" , "<name>" , "<appdate>" , "<customertype>" , "<status>" , "<rep>" , "<repname>" , "<searchfeild>"
    When I click on customer data
    Then I verify "<billingadd>" , "<email>" , "<preferredlang>"

    Examples: Test data for the E2E scenario
      | username | pwd      | email                        | custno   | name         | appdate   				| customertype 	| status  | rep    | repname      | searchfeild                  | billingadd              | email                 		  	| preferredlang 	|
      | vnallani | @Lt12345 | rajanikanth123nc@yopmail.com | 15558278 | BRKLN, BRKFN | 5/20/2019 3:15:58 PM 	| Club     		| General | 397288 | Lasker, Lorin | rajanikanth123nc@yopmail.com | Santa Monica, CA 90404 |  rajanikanth123nc@yopmail.com 	|  English    	 	|
			