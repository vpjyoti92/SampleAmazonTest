package step_definitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/java/features",
			glue = "step_definitions",
			tags = "@Test")
	public class RunCakeTest {
	}



