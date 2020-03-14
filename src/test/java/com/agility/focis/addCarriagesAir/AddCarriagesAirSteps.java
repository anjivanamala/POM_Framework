package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddCarriagesAirSteps extends BaseSteps {
    private WebDriver driver;
    AddCarriagesAirPage addCarriagesAirPage;

    public AddCarriagesAirSteps() throws IOException {
        this.driver = getDriver();
        addCarriagesAirPage = new AddCarriagesAirPage(this.driver);

    }
    public void clickOnAddAirportToAirport() throws InterruptedException {
        clickOnTab("Movement");
    }

    public void addAirportToAirport( String FlightNumber,String AirportOfDeparture,String AirportOfArrival,String ETD,String ETDTime ,String ETA ,String ETATime ,String Supplier,String Cost,String Revenue){

    }

    }
