package com.agility.focis.performActivities.mbli;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MBLISteps extends CommonSteps {
    private WebDriver driver;
    MBLIPage MBLIPage;

    public MBLISteps() throws IOException {
        this.driver = getDriver();
        MBLIPage = new MBLIPage(this.driver);

    }

    public void performMBLI() {
    }
}
