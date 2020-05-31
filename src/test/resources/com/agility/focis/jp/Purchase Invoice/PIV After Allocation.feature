@PIVRegression @Regression @PIV @AfterAllocation
Feature: Purchase Invoice - After Allocation Of Charges
#100149975
  Background: Login
    Given User is logged into FOCiS Application

#  @PIVAllocateToJobTesting
  Scenario Outline: (Pre Condition Scenario) - Create Air Freight - E2E Job and Add Estimates

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
    And Edits Description of Goods
    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  |
      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> |
    And Add Origin with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |
    And Add Destination with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |
    And adds Charges as below
      | Charge Type   | Charge Name            | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Origin        | Documentation          | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin        | Booking Fees           | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | International | Airline Fuel Surcharge | Garrisons Logistics Pvt Ltd | -80  | INR           | 60      | INR              |
      | International | Advance fee            | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | Destination   | Inland Fuel Surcharge  | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |
      | Destination   | Booking Fees           | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |
    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope | OriginStakeholder    | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | O_Haulier                   | O_Coll_Date | O_Del_Date | D_Haulier         | D_Coll_Date | D_Del_Date |
      | DR1     | Job        | Job Booking     | Air Freight | Expedited   | E2E      | Flyjac Logistics- IN | Smatbot- US            | DAT      | IN             | Mumbai                  | Air Export        | Branch      | Yes           | 5910     | US                  | Chicago                      | Air Import             | Branch           | Yes                | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1           | 3          | BESTWAY TRANSPORT | 15          | 16         |


  Scenario Outline: Validate the displaying of status as "Fully Allocated" when "To Be Allocated" amount row is Zero in PIV Screen
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Allocates Charges
    Then Invoice Status should be "Fully Allocated"
    And PIV Amount, Tax Amount and Currency should be displayed as "0.00" , "0.00" ,"<Currency>" in "To be Allocated Amount" Row
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the displaying of "Complete" button after the status of PIV header changed to Fully Allocated
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Allocates Charges
    Then "Complete" button should be displayed
    Then Invoice Status should be "Fully Allocated"
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the generating of Purchase Invoice after modifying the tax code after Allocation of charges to the header
#  100150184
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
    And Edits Description of Goods
    And Adds Airport To Airport with Carrier As "<Carrier>" along with below details
      | Flight Number  | Airport Of Departure | Airport Of Arrival | ETD   | ETD Time  | ETA   | ETA Time  |
      | <FlightNumber> | <AOD>                | <AOA>              | <ETD> | <ETDTime> | <ETA> | <ETATime> |
    And Add Origin with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <O_Haulier>  | <O_Coll_Date>         | <O_Del_Date>        |
    And Add Destination with Haulage Arrangement as "Agility"
      | Haulier Name | Cargo Collection Date | Cargo Delivery Date |
      | <D_Haulier>  | <D_Coll_Date>         | <D_Del_Date>        |
    And adds Charges as below
      | Charge Type   | Charge Name            | Supplier                    | Cost | Cost Currency | Revenue | Revenue Currency |
      | Origin        | Documentation          | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | Origin        | Booking Fees           | Garrisons Logistics Pvt Ltd | 100  | INR           | 120     | INR              |
      | International | Airline Fuel Surcharge | Garrisons Logistics Pvt Ltd | -80  | INR           | 60      | INR              |
      | International | Advance fee            | Garrisons Logistics Pvt Ltd | -70  | INR           | 50      | INR              |
      | Destination   | Inland Fuel Surcharge  | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |
      | Destination   | Booking Fees           | BESTWAY TRANSPORT           | 100  | USD           | 120     | USD              |
    And Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Allocates Charges
    And modifies Tax Code for a Charge
    And Updates PIV Amount and Tax Amount as per Tax Code modification

    Examples:
      | DataRow | MenuOption | ChildMenuOption | Product     | ProductType | JobScope | OriginStakeholder    | DestinationStakeholder | IncoTerm | Origin_Country | Origin_NetworkComponent | Origin_Department | Origin_Type | Origin_IsLive | O_Entity | Destination_Country | Destination_NetworkComponent | Destination_Department | Destination_Type | Destination_IsLive | D_Entity | Carrier | FlightNumber | AOD | AOA | ETD | ETDTime | ETA | ETATime | O_Haulier                   | O_Coll_Date | O_Del_Date | D_Haulier         | D_Coll_Date | D_Del_Date | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Job        | Job Booking     | Air Freight | Expedited   | E2E      | Flyjac Logistics- IN | Smatbot- US            | DAT      | IN             | Mumbai                  | Air Export        | Branch      | Yes           | 5910     | US                  | Chicago                      | Air Import             | Branch           | Yes                | 1200     | EK      | EK123        | BOM | ORD | 7   | 12      | 14  | 12      | Garrisons Logistics Pvt Ltd | 1           | 3          | BESTWAY TRANSPORT | 15          | 16         | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the displaying of status as "Partially Allocated" when "To Be Allocated" amount row is not Zero in PIV Screen
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Partially Allocates Charges
    Then Invoice Status should be "Partially Allocated"
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the Deleting of Charges from Allocated charge list after Allocation
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Allocates Charges
    Then user should be able to delete random charges
    And Invoice Status should be "Partially Allocated"
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |


  Scenario Outline: Validate the Adding of Charges from Allocated charge list after Allocation
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Partially Allocates Charges
    And user clicks on "Allocate to Jobs/ Consol" button
    Then user should be able to add charges
    And Invoice Status should be "Fully Allocated"
    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the Tax Summary Table Amounts after allocation of charges to PIV header
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Partially Allocates Charges
    Then Total PIV Amount of PIV Summary Table should be populated as "Sum of Net PIVed Amounts"
    And Discount Value of PIV Summary Table should be populated as "0.00"
    And Write of Amount of PIV Summary Table should be populated as "0.00"
    And Total Net Amount of PIV Summary Table should be populated as "PIV Amount - (Discount  Value + Write Off Amount)"
    And Currency of PIV Summary Table should populated as "<Currency>"


    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  Scenario Outline: Validate the PIV Summary Table Amounts after allocation of charges to PIV header
    When Creates PIV Header with below details
      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
    And Allocates Charges
    Then Total Charge Amount of Tax Summary Table for a Tax Code should be populated as "Sum of Corresponding Net PIVed Amounts"
    And Tax Rate of Tax Summary Table should be populated correctly
    And Total Tax Amount of Tax Summary Table should be populated as "Sum of Corresponding Tax Amounts"
    And Supplier Total Tax Amount of Tax Summary Table should be populated as "Sum of Corresponding Supplier Tax Amounts"
    And Currency of PIV Summary Table should populated as "<Currency>"

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |

  @PIVAllocateToJobTesting
  Scenario Outline: Validate the Total Summary Table Amounts after Allocation of Charges to PIV header
#    When Creates PIV Header with below details
#      | Invoice Type | Invoice SubType | Entity Code | Org Component  | Supplier Name | Supplier Invoice Date | PIV Amount  | Tax Amount  | Currency   |
#      | <PIVType>    | <PIVSubType>    | <Entity>    | <OrgComponent> | <Haulier>     | <PIVInvoiceDate>      | <PIVAmount> | <TaxAmount> | <Currency> |
#    And Allocates Charges
    When selects "Purchase Invoice/Credit" from "Purchase Invoice/Credit/Fast Check" from "Job" Menu
    And Edits PIV with Supplier Invoice Number "20200530162956"
    Then Total Charge Amount of Tax Summary Table for a Tax Code should be populated as "Sum of Corresponding Net PIVed Amounts"
    And Tax Rate of Tax Summary Table should be populated correctly
    And Total Tax Amount of Tax Summary Table should be populated as "Sum of Corresponding Tax Amounts"
    And Supplier Total Tax Amount of Tax Summary Table should be populated as "Sum of Corresponding Supplier Tax Amounts"
    And Currency of PIV Summary Table should populated as "<Currency>"

    Examples:
      | DataRow | PIVType          | PIVSubType | Entity | OrgComponent      | Haulier                     | PIVInvoiceDate | PIVAmount | TaxAmount | Currency |
      | DR1     | Purchase Invoice | Freight    | 5910   | Mumbai Air Export | Garrisons Logistics Pvt Ltd | Today          | 100       | 0.00      | INR      |
