package com.agility.focis.performActivities.cbc;

import com.agility.focis.addCarriagesAir.AddCarriagesAirPage;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CBCSteps extends CommonSteps {
    private WebDriver driver;
    CBCPage cbcPage;
    AddCarriagesAirPage addCarriagesAirPage;

    public CBCSteps() throws IOException {
        this.driver = getDriver();
        cbcPage = new CBCPage(this.driver);
        addCarriagesAirPage = new AddCarriagesAirPage(this.driver);

    }

    public void performCBC() throws InterruptedException {
        clickOnPerformActivityAndSwithToWindow("Carrier Booking Confirmation");
    }
}
