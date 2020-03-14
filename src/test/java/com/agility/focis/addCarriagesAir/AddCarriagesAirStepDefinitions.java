package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddCarriagesAirStepDefinitions<AddMainCarriage> {
    AddCarriagesAirSteps addCarriagesAirSteps;
    BaseSteps baseSteps;

    public AddCarriagesAirStepDefinitions() throws IOException {

        addCarriagesAirSteps = new AddCarriagesAirSteps();
    }

    @When("Adds Airport To Airport with Carrier As {string} along with below details")
    public void adds_Airport_To_Airport_with_Carrier_As_along_with_below_details(String carrier,List<Map<String,String>> airportToAirport) {
        for (int i=0;i<airportToAirport.size();i++){

        }

    }


}