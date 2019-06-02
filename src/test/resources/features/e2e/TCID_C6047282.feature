@OIM
Feature: To Validate Different aspects of Customers in OIM

Scenario Outline: Verifying Customer details in OIM 
    Given I am on OIM home page    
    When I login with userName "<LoginUsername>" and password "<LoginPassword>"    
    And I click on manage
    And I click on users under administration    
    When I enter email "<Email>" and click on search
    When I click on user login link
    Then I verify "<FirstName>" and "<LastName>" should be displayed    	
    Then I verify "<TelephoneNumber>" should be displayed under contact information
    And I verify "<Locale>" should be displayed under preferences           
    And I verify "<Username>","<DOB>","<Gender>","<CustomerType>","<GNCCustomerID>","<LeadWheelType>","<BillingAddress>","<ShippingAddress>","<IsLiferayProvisioned>","<IsEBSProvisioned>" and "<IsBYDESIGNProvisioned>" should be displayed under other attributes
      
      
Examples: Test data for the OIM scenario
|LoginUsername|LoginPassword|Email|FirstName| LastName | TelephoneNumber | Locale  | Username | DOB        | Gender | CustomerType        | GNCCustomerID | LeadWheelType | BillingAddress       | ShippingAddress      | IsLiferayProvisioned | IsEBSProvisioned | IsBYDESIGNProvisioned |
|xelsysadm|Beachbody@123|rajanikanth123nc@yopmail.com| BRKFN     | BRKLN    | (424) 407-6433  | English (United States) | 15558278 | 1/20/1985 | FEMALE | CLUB,REGISTEREDUSER |      15558278 | SUCCESSCLUB   | 3301 Exposition Blvd | 3301 Exposition Blvd | YES|YES | YES       		  |