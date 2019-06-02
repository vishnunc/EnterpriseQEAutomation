@e2e
Feature: COO Customer Details

  Scenario Outline: Verify Customer Details in Coach Office
    Given Launch COO Application
    When Enter username "<username>" and password "<password>"
    And Click on Sign In button
    When User Clicks on My Customers under Monitor My Business
    Then Customer Report page should be displayed
    When User Enters Email address "<EmailAddress>" and click on search
    Then Validate "<JoinDate>", "<FirstName>", "<LastName>", "<CustomerID>", "<CustomerType>", "<CustomerSource>" , "<PhoneNumber>", "<LastOrderDate>" , "<Email>"
    When User Clicks on the top arrow near join date field
    Then Validate "<HomeDirect>" , "<LanguagePreference>" , "<Street1>" , "<Street2>" , "<City>" , "<State>" , "<PostalCode>" , "<Country>" 

    Examples: 
      | username|password|EmailAddress|FirstName|LastName|CustomerID|CustomerType|CustomerSource|PhoneNumber|LastOrderDate|Email|HomeDirect|LanguagePreference|Street1|Street2|City|State|PostalCode|Country|JoinDate|
      | wave11uscoach19@yopmail.com|Be@chb0dy|ZoIe1551803370@yopmail.com|EgMsfd|ZoIe|14932572|Regular|My Site|(425) 555-5555|3/5/2019|ZoIe1551803370@yopmail.com|No|English|819 2nd Ave|Ste 1900|Seattle|WA|98104|United States|3/5/2019|