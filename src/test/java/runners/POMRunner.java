package runners;

import Base.DriverInstantiation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class POMRunner extends DriverInstantiation {
    public WebDriver driver;

    @BeforeClass
    public void launchBRowser() throws IOException {
        setDriver();
        String loginUrl = loginURL();
        driver = getDriver();
        driver.get(loginUrl);
    }

    @Test
    public void navigateToTupaki() {
        System.out.println(driver.getCurrentUrl());
    }

    @AfterMethod
    public void killDriver() {
        driver.quit();
    }
}
