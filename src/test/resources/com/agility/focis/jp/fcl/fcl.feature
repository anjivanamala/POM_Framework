Feature: JP - FOCiS

  @gui
  Scenario Outline: Create a FCL Job

    Given User is logged into FOCiS Application
    When selects "<MenuOption>" from Menu
    And selects "<ChildMenuOption>" from Child Menu
    Then "Job Creation" Page displays
    And Creates a Job with Below Details
      | ProductType   | JobScope   | Product   |
      | <ProductType> | <JobScope> | <Product> |
    Examples:
      | DataRow | MenuOption | ChildMenuOption | ChildMenuOption2 |
      | DR1     | Job        | Job Creation    |                  |
      | DR2     | MDM        | Events          |                  |

  @gui
  Scenario Outline: Create a FCL Job2

    Given User is logged into FOCiS Application
    When selects "<MenuOption>" from Menu
    And selects "<ChildMenuOption>" from Child Menu
    Then "Job Creation" Page displays

    Examples:
      | DataRow | MenuOption | ChildMenuOption |
      | DR1     | Job        | Job Creation    |

    Scenario : Test 3
      Given User is logged into FOCiS Application