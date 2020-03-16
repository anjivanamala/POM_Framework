package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import javax.xml.soap.SAAJResult;
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
    public void adds_Airport_To_Airport_with_Carrier_As_along_with_below_details(String carrier, List<Map<String, String>> airportToAirport) throws InterruptedException {
        for (int i = 0; i < airportToAirport.size(); i++) {
            String flightNumber = airportToAirport.get(i).get("Flight Number");
            String airportOfDeparture = airportToAirport.get(i).get("Airport Of Departure");
            String airportOfArrival = airportToAirport.get(i).get("Airport Of Arrival");
            String etd = airportToAirport.get(i).get("ETD");
            String etdTime = airportToAirport.get(i).get("ETD Time");
            String eta = airportToAirport.get(i).get("ETA");
            String etaTime = airportToAirport.get(i).get("ETA Time");
            String supplier = airportToAirport.get(i).get("Supplier");
            String cost = airportToAirport.get(i).get("Cost");
            String revenue = airportToAirport.get(i).get("Revenue");
            addCarriagesAirSteps.addAirportToAirport(carrier, flightNumber, airportOfDeparture, airportOfArrival, etd, etdTime, eta, etaTime, supplier, cost, revenue);
        }

    }

    @When("Add Origin with Haulage Arrangement as {string}")
    public void add_Origin_with_Haulage_Arrangement_as(String haulierType, List<Map<String, String>> originInfo) throws InterruptedException {
        for (int i = 0; i < originInfo.size(); i++) {
            String haulierName = originInfo.get(0).get("Haulier Name");
            String originCargoCollectionDate = originInfo.get(0).get("Cargo Collection Date");
            String originCargoDeliveryDate = originInfo.get(0).get("Cargo Delivery Date");
            addCarriagesAirSteps.addOrigin(haulierType, haulierName, originCargoCollectionDate, originCargoDeliveryDate);
        }
    }

    @When("Add Destination with Haulage Arrangement as {string}")
    public void add_Destination_with_Haulage_Arrangement_as(String haulierType, List<Map<String, String>> destinationInfo) throws InterruptedException {
        for (int i = 0; i < destinationInfo.size(); i++) {
            String haulierName = destinationInfo.get(0).get("Haulier Name");
            String destinationCargoCollectionDate = destinationInfo.get(0).get("Cargo Collection Date");
            String destinationCargoDeliveryDate = destinationInfo.get(0).get("Cargo Delivery Date");
            addCarriagesAirSteps.addDestination(haulierType, haulierName, destinationCargoCollectionDate, destinationCargoDeliveryDate);

        }
    }


}