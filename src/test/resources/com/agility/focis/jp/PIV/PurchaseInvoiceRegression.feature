@PIV
Feature: PIV Regression

  Scenario Outline: Validate all the field in header after Creating the PIV Header

    Given User is logged into FOCiS Application
#    When selects "<ChildMenuOption>" from "<MenuOption>" Menu
#    And user clicks on "Book Without Template" button
#    And creates  a new "<Product>" - "<ProductType>" - "<JobScope>" Job with following details
#    And selects "<OriginStakeholder>" as Origin Stakeholder & "<DestinationStakeholder>" as Destination Stakeholder
#    And Clicks on "Next" button
#    And selects "<IncoTerm>" as Incoterm
#    And selects "Origin" Office as below
#      | Country          | Type          | NetworkComponent          | Department          | IsLive          |
#      | <Origin_Country> | <Origin_Type> | <Origin_NetworkComponent> | <Origin_Department> | <Origin_IsLive> |
#    And selects "Destination" Office as below
#      | Country               | Type               | NetworkComponent               | Department               | IsLive               |
#      | <Destination_Country> | <Destination_Type> | <Destination_NetworkComponent> | <Destination_Department> | <Destination_IsLive> |
#    And Clicks on "Next" button
#    And Clicks on "Next" button
#    And Clicks on "Initiate Job" button
#    Then  new "<Product>" - "<ProductType>" - "<JobScope>" Job is created successfully
#    When Edits Packages as below
#      | Packages | Type | Per piece Wt | Gross Wt | Length | Width | Height | Volume | Shipping Marks | Description  |
#      | 100      | BOX  | 10           |          | 30     | 25    | 40     |        | Laptops        | Dell Laptops |
#      | 10       | BOX  | 10           |          | 20     | 15    | 10     |        | Laptops        | HP Laptops   |
#      | 50       | BOX  | 5            |          | 20     | 15    | 10     |        | Laptops        | MacBook Pro  |
#    And Edits Description of Goods
#    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
#      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  | Supplier   | Cost   | Revenue   |
#      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> | <Supplier> | <Cost> | <Revenue> |
#    And Add Origin with Haulage Arrangement as "Agility"
#      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
#      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |
#    And Add Destination with Haulage Arrangement as "Agility"
#      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
#      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |
#    And adds Charges as below
#      | Charge Name   | Supplier  | Cost | Revenue |
#      | Documentation | Garissons | 100  | 120     |
#      | Booking Fee   | Garissons | 100  | 120     |
    When selects "<ChildSubMenuOption>" from "<ChildMenuOption>" from "<MenuOption>" Menu
    And Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <D_Entity>  | <D_Haulier>   | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |

    Examples:
      | DataRow | MenuOption | ChildMenuOption                    | ChildSubMenuOption      | Product     | ProductType | JobScope | OriginStakeholder | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | Supplier          | Cost | Revenue | O_Haulier         | O_Coll_Date | O_Del_Date | D_Haulier                   | D_Coll_Date | D_Del_Date | PIVType          | PIVSubType | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Job        | Purchase Invoice/Credit/Fast Check | Purchase Invoice/Credit | Air Freight | Expedited   | E2E      | STK20016776       | STK20016775            | DAT      | US             | Chicago                 | Air Export        | Branch      | Yes           | 1200     | IN                  | Mumbai                       | Air Import             | Branch           | Yes                | 5910     | EK      | EK123        | ORD | BOM | 7   | 12      | 14  | 12      | BESTWAY TRANSPORT | 1    | 2       | BESTWAY TRANSPORT | 1           | 3          | Garrisons Logistics Pvt Ltd | 15          | 16         | Purchase Invoice | Freight    | Today          | 150.00    | 0.00      | INR      |