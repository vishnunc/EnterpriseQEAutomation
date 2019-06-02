@ByDesign @C6047331 @Customer_Order_Verification
Feature: ByDesign Order Verification

  Scenario Outline: Verifying the order details in ByDesign
    Given I am on ByDesign Home Page
    When I enter "<username>" , "<pwd>" to login BYDesign
    And I click on customers option from search menu
    When I enter "<email>" and click on search
    Then I can see "<custno>" , "<name>"  , "<appdate>" , "<customertype>" , "<status>" , "<rep>" ,  "<repname>" , "<searchfield>"
    When I click on customer data
    Then I verify "<billingaddress>"
    When I click on order number
    Then I verify order info "<orderShippingadd>","<orderdate>","<bonusdate>","<item>","<product>","<qty>","<zerooutshakeologyitems>" , "<oracleordernum>" , "<ebsordertype>"
    
    Examples: 
      | username | pwd      | email                        | custno   | name        | appdate   				| customertype | status  | rep    | repname      | searchfield                  | billingaddress           	| orderShippingadd|orderdate|bonusdate|item|product|qty|zerooutshakeologyitems| oracleordernum| ebsordertype|
      | vnallani | @Lt12345 | rajanikanth123nc@yopmail.com | 15558278 | BRKLN,BRKNF | 5/20/2019 3:15:58 PM 		| Club         | General | 397288 | Lasker, Lorin | rajanikanth123nc@yopmail.com | Santa Monica, CA 90404	|Santa Monica, CA 90404|5/20/2019|5/20/2019|MDBCPCF|CORE DE FORCE and Shakeology Challenge Pack|1|Yes|STORE_139770003|WEB ORDER_NT|
