@COO_Registration
Feature: New coach registration and placing order

  Scenario Outline: New coach registration
    Given I am on COO home page
    When I click on Become Coach Link
    Then signup page should be displayed
    And I enter my information "<country>","<language>","<pswd>","<phone>","<month>","<day>","<year>","<govtid>","<sign>"
    When I click on Continue
    Then Coach registered sucessfully and navigated to challenge pack step
    When I selects challenge pack "<pack>"
    And I selects "<packtype>" for buying
    And I fill product details with "<flavor>","<packaging>","<recover>" , "<recovpackaging>" and "<qty>" options
    And I click on select and continue to cart
    Then Navigated to topsellers step
    When I click on no thanks complete my enrollment button
    And I click on continue to shopping
    Then I enter my shipping information "<address>","<city>","<state>","<zip>"
    And I validates the QAS address
    Then I select shipping option "<shipping>" and click on continue
    And I enter payment information "<ccfname>" , "<cclname>" , "<cardnno>" , "<ccmonth>" , "<ccyear>" , "<cvv>" 
		And I click on submit
	
    Examples: Test data
      | country | language | pswd        | phone      | month | day | year | govtid    | sign      | pack            | packtype                               | flavor | packaging | recover | recovpackaging | qty | address              | city         | state | zip   | shipping | ccfname | cclname | cardno           | ccmonth | ccyear | cvv |
      | US      | en       | Coosign#123 | 3456789012 |    01 |  22 | 1993 | 567895432 | /s/SMAPLE | 21DayFixEXTREME | 21DPerformancePackAA:performancePack:3 | Lemon  |        32 | Orange  |             20 |   1 | 3301 Exposition Blvd | Santa Monica | CA    | 90404 |        1 | testing | vv      | 4444444444444448 |    08 | 2024 | 123 |
