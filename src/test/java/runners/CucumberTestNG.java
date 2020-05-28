package runners;

import com.agility.focis.base.DriverInstantiation;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.logging.Logger;


@CucumberOptions(features = "src/test/resources/com/agility/focis/jp", tags = {"@AllocateJob"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runwebat",
        "json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt", "timeline:target/timeline"},
        glue = "com.agility.focis"
//          , dryRun=true
//        @XMLValidations,@GenerateInvoices
)


public class CucumberTestNG extends AbstractTestNGCucumberTests {
    private WebDriver driver;

    @BeforeMethod
    public void instantiateDriver() throws IOException {
        DriverInstantiation.setDriver();

    }

//    @AfterMethod
//    public void killDriver() {
//        driver = DriverInstantiation.getDriver();
//        driver.quit();
//        System.out.println("I quit the Driver");
//    }

}
