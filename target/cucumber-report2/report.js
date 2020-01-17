$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/agility/focis/jp/fcl/fcl.feature");
formatter.feature({
  "name": "JP - FOCiS",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Create a FCL Job",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "User is logged into FOCiS Application",
  "keyword": "Given "
});
formatter.step({
  "name": "selects \"\u003cMenuOption\u003e\" from Menu",
  "keyword": "When "
});
formatter.step({
  "name": "selects \"\u003cChildMenuOption\u003e\" from Child Menu",
  "keyword": "And "
});
formatter.step({
  "name": "\"Job Creation\" Page displays",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "DataRow",
        "MenuOption",
        "ChildMenuOption"
      ]
    },
    {
      "cells": [
        "DR1",
        "Job",
        "Job Creation"
      ]
    },
    {
      "cells": [
        "DR2",
        "MDM",
        "Events"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a FCL Job",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "User is logged into FOCiS Application",
  "keyword": "Given "
});
formatter.match({
  "location": "FCLStepDefinitions.user_is_logged_into_FOCiS_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects \"Job\" from Menu",
  "keyword": "When "
});
formatter.match({
  "location": "FCLStepDefinitions.selects_from_Menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects \"Job Creation\" from Child Menu",
  "keyword": "And "
});
formatter.match({
  "location": "FCLStepDefinitions.selects_from_Child_Menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Job Creation\" Page displays",
  "keyword": "Then "
});
formatter.match({
  "location": "FCLStepDefinitions.page_displays(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create a FCL Job",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "User is logged into FOCiS Application",
  "keyword": "Given "
});
formatter.match({
  "location": "FCLStepDefinitions.user_is_logged_into_FOCiS_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects \"MDM\" from Menu",
  "keyword": "When "
});
formatter.match({
  "location": "FCLStepDefinitions.selects_from_Menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects \"Events\" from Child Menu",
  "keyword": "And "
});
formatter.match({
  "location": "FCLStepDefinitions.selects_from_Child_Menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Job Creation\" Page displays",
  "keyword": "Then "
});
formatter.match({
  "location": "FCLStepDefinitions.page_displays(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Create a FCL Job2",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "User is logged into FOCiS Application",
  "keyword": "Given "
});
formatter.step({
  "name": "selects \"\u003cMenuOption\u003e\" from Menu",
  "keyword": "When "
});
formatter.step({
  "name": "selects \"\u003cChildMenuOption\u003e\" from Child Menu",
  "keyword": "And "
});
formatter.step({
  "name": "\"Job Creation\" Page displays",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "DataRow",
        "MenuOption",
        "ChildMenuOption"
      ]
    },
    {
      "cells": [
        "DR1",
        "Job",
        "Job Creation"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a FCL Job2",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "User is logged into FOCiS Application",
  "keyword": "Given "
});
formatter.match({
  "location": "FCLStepDefinitions.user_is_logged_into_FOCiS_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects \"Job\" from Menu",
  "keyword": "When "
});
formatter.match({
  "location": "FCLStepDefinitions.selects_from_Menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects \"Job Creation\" from Child Menu",
  "keyword": "And "
});
formatter.match({
  "location": "FCLStepDefinitions.selects_from_Child_Menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Job Creation\" Page displays",
  "keyword": "Then "
});
formatter.match({
  "location": "FCLStepDefinitions.page_displays(String)"
});
formatter.result({
  "status": "passed"
});
});