package runners;

import Base.DriverInstantiation;
import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;


@CucumberOptions(features = "src/test/resources/com/agility/focis/jp/fcl", tags = {"@gui"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runwebat",
        "json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt"},
        glue = "com.agility.focis")
public class CucumberTestNG extends AbstractTestNGCucumberTests {
    public WebDriver driver;


    @AfterMethod
    public void killDriver() {
        driver = DriverInstantiation.getDriver();
        driver.quit();
    }

}
