package runners;

import Base.DriverInstantiation;
import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@CucumberOptions(features = "src/test/resources/com/agility/focis/jp/fcl", tags = {"@gui2"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report2",
        "json:target/cucumber-report2/cucumber.json",
        "rerun:target/cucumber-report2/rerun.txt"},
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

    @AfterClass
    public void generateACucmberReport() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber-report/cucumber.json");


        String buildNumber = "1";
        String projectName = "Java_Automation";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration - check javadoc for details
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
// do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");

//// optionally add metadata presented on main page via properties file
//        List<String> classificationFiles = new ArrayList<String>();
//        classificationFiles.add("properties-1.properties");
//        classificationFiles.add("properties-2.properties");
//        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();


    }

}
