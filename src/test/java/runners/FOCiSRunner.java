package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/agility/focis/jp/fcl/fcl.feature"
        ,glue={""}
)


public class FOCiSRunner {
}
