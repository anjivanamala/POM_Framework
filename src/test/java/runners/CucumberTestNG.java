package runners;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/com/agility/focis/jp/fcl", tags = {"@gui"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runwebat",
        "json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt"},
        glue = "com.agility.focis")
public class CucumberTestNG extends AbstractTestNGCucumberTests {


}
