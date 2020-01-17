package runners;

import Base.DriverInstantiation;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CucumberOptions(features = "src/test/resources/com/agility/focis/jp/fcl", tags = {"@gui"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report2",
        "json:target/cucumber-report2/cucumber.json",
        "rerun:target/cucumber-report2/rerun.txt"
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/html/ExtentReport.html "
},
        glue = "com.agility.focis")
public class CucumberTestNG extends AbstractTestNGCucumberTests {
    public WebDriver driver;

    @BeforeMethod
    public void instantiateDriver() throws IOException {
        DriverInstantiation.setDriver();
    }

    @AfterMethod
    public void killDriver() {
        driver = DriverInstantiation.getDriver();
        driver.quit();
        System.out.println("I quit the Driver");
    }


    //    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src/test/config/extent-config.xml"));

    }

}
