package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/agility/focis/jp/Activities",tags = {"@Tasks"}
        ,glue={""}
)


public class FOCiSRunner {

}
