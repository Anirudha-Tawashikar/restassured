package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature",
                 glue = {"stepdefination"},
                 tags = "@Deleteplace") // Corrected the tags assignment here
public class testrunner {
}


