package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
features= {"Features\\login.feature"},
glue= {"StepDefinition"},
monochrome=true,
plugin= {"pretty","html:target/htmlreport.html"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests
{

}
