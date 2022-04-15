package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags= "@acceptance",
        glue = {"stepDefinition"},
        plugin = {
                //"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "pretty","html:target/cucumber", "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class testRunner {

}
