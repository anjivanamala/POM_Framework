@InitiateJob @Air
Feature: Initiate Job - Air Freight - Expedited

  @Expedited @E2E @BackToBack
  Scenario Outline: Create an  Air Freight - Expedited - E2E - BackToBack Job without Template
    Given User is logged into FOCiS Application
    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
    And user clicks on "Book Without Template" button
    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
    And Clicks on "Next" button
    And selects "<IncoTerm>" as Incoterm
    And selects "Origin" Office as below
      | Country          | Type          | NetworkComponent          | Department          | IsLive          |
      | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |
    And selects "Destination" Office as below
      | Country               | Type               | NetworkComponent               | Department               | IsLive               |
      | <Destination_Country> | <Destination_Type> | <Destination_NetworkComponent> | <Destination_Department> | <Destination_IsLive> |
    And Clicks on "Next" button
    And Clicks on "Next" button
    And Clicks on "Initiate Job" button
    Then  new "<Product>" - "<ProductType>" - "<JobScope>" Job is created successfully
    When Edits Packages as below
      | Packages | Type | Per piece Wt | Gross Wt | Length | Width | Height | Volume | Shipping Marks | Description  |
      | 100      | BOX  | 10           |          | 30     | 25    | 40     |        | Laptops        | Dell Laptops |
      | 10       | BOX  | 10           |          | 20     | 15    | 10     |        | Laptops        | HP Laptops   |
      | 50       | BOX  | 5            |          | 20     | 15    | 10     |        | Laptops        | MacBook Pro  |
    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  | Supplier   | Cost   | Revenue   |
      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> | <Supplier> | <Cost> | <Revenue> |


    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope | OriginStakeholder | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | Supplier | Cost | Revenue |
      | DR1     | Job        | Job Booking     | Air Freight | Expedited   | E2E      | STK20016776       | STK20016775            | DAT      | US             | Chicago                 | Air Export        | Branch      | Yes           | IN                  | Mumbai                       | Air Import             | Branch           | Yes                | EK      | 123          | BOM | ORD | 7   | 12      | 14  | 12      | Garrison | 1    | 2       |
#      | DR2     | Job        | Job Booking     | Air Freight | Expedited   | Destination Only | STK20016776       | STK20016775            | DAT      |                |                         |                   |             |               | IN                  | Mumbai                       | Air Import             | Branch           | Yes                |              |     |     |     |         |     |         |          |      |         |
#      | DR3     | Job        | Job Booking     | Air Freight | Expedited   | Origin Only      | STK20016776       | STK20016775            | DAT      | US             | Chicago                 | Air Export        | Branch      | Yes           |                     |                              |                        |                  |                    |              |     |     |     |         |     |         |          |      |         |
