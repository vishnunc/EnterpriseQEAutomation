Feature: COO Customer Details
Scenario Outline: Verify Customer Details in Coach Office
  Given Launch COO Application
    When Enter username "<UserName>" and password "<Password>"
    And Click on Sign In button
  	When User Clicks on My Personal & Customer Orders under Monitor My Business
    Then Order Report Page should be displayed
    When User Enters orderNo "<OrderNumber>" and Clicks on Search
    Then Validate orderDate as "<OrderDate>" customerId as "<CustomerID>" firstName as "<FName>" lastName as "<LName>" orderNumber as "<OrderNo>" homeDirect as "<HomeDirect>" emailId as "<EmailID>" amont as "<Amount>" phone as "<Phone>" status as "<Status>" volume as "<Volume>" trackingNumber as "<TrackingNumber>"
    When User Clicks on the top arrow near order date field
    Then Validate productName as "<ProductName>" orderType as "<OrderType>" 
    
Examples:
    |UserName|Password|OrderNumber|OrderDate|CustomerID|FName|LName|OrderNo|HomeDirect|EmailID|Amount|Phone|Status|Volume|ProductName|OrderType|TrackingNumber|
    |wave11uscoach19@yopmail.com|Be@chb0dy|119940301|3/5/2019|14932572|EgMsfd|ZoIe|STORE_119940301|No|ZoIe1551803370@yopmail.com|$51.58|(425) 555-5555	|POSTED|24|Chin-Up Max|WEB ORDER_NT||