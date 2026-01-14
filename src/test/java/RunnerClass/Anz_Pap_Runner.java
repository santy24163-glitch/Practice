package RunnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/anz_pap.feature",glue = {"StepDefinition", "Hooks"}, monochrome = true,
tags = "@scenario1", plugin = {"pretty", "html:test-output/htmlReport/report.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"json:test-output/jsonReporter/jsonReport.json"})
public class Anz_Pap_Runner extends AbstractTestNGCucumberTests {
}
