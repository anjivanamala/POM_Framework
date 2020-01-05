package com.agility.focis.base;

import Base.DriverInstantiation;
import com.sun.tools.xjc.Driver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseSteps extends DriverInstantiation {
    public WebDriver driver;

    public BaseSteps() throws IOException {
        setDriver();
        this.driver = getDriver();
    }
}
