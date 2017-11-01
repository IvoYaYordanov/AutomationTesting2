package runner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class) its with JUnit
@CucumberOptions(
        features = {"src/test/java/features"},
        format = {"json:target/cucumber.json","html:target/site/cucumber2"},
        glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests {

}
