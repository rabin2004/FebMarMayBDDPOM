package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\User\\eclipse-workspace\\FebMarMayBDDPOM\\src\\test\\java\\features",
				glue = "stepDefinition",
				monochrome = true,
				plugin = {"pretty", "html:target/Html report/cucumberReport.html", "json:target/Json report/jsonReport"},
				tags = "@Regression"
		)
public class TestRunner {

}
