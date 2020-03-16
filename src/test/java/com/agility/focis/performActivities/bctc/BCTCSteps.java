package com.agility.focis.performActivities.bctc;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BCTCSteps extends CommonSteps {
    private WebDriver driver;
    BCTCPage BCTCPage;

    public BCTCSteps() throws IOException {
        this.driver = getDriver();
        BCTCPage = new BCTCPage(this.driver);

    }

    public void completeBCTC() {
    }
}
